package com.dasbor.pribadi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "DasborMainActivity";
    private static final String OTA_URL = "https://raw.githubusercontent.com/habielmaulanaaa-svg/dasbor-pribadi/main/index.html";
    private static final String PREF_NAME = "dasbor_prefs";
    private static final String KEY_OTA_HASH = "ota_bundle_hash";

    private WebView webView;
    private FrameLayout rootLayout;
    private final ExecutorService backgroundExecutor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private String pendingAction = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configureSystemBars();

        rootLayout = new FrameLayout(this);
        rootLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        rootLayout.setBackgroundColor(Color.parseColor("#0e1621"));

        setupWebView();
        rootLayout.addView(webView);
        setContentView(rootLayout);

        handleIntent(getIntent());

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webView != null && webView.canGoBack()) {
                    webView.goBack();
                } else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });

        // Cek pembaruan OTA di latar belakang jika terhubung ke internet
        checkForOtaUpdate(false);
    }

    private void configureSystemBars() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#0e1621"));
        window.setNavigationBarColor(Color.parseColor("#0e1621"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true);
        }
    }

    private void setupWebView() {
        webView = new WebView(this);
        webView.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        webView.setBackgroundColor(Color.parseColor("#0e1621"));
        webView.setLayerType(View.LAYER_TYPE_NONE, null);
        webView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setTextZoom(100);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            settings.setOffscreenPreRaster(true);
        }

        webView.addJavascriptInterface(new DasborBridge(), "DasborBridge");

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Dasbor Pribadi")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok, (d, w) -> result.confirm())
                        .setCancelable(false)
                        .show();
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Konfirmasi")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok, (d, w) -> result.confirm())
                        .setNegativeButton(android.R.string.cancel, (d, w) -> result.cancel())
                        .setCancelable(false)
                        .show();
                return true;
            }

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d(TAG, "WebConsole: " + consoleMessage.message() + " -- From line "
                        + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                return true;
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();
                return handleUrlScheme(uri);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return handleUrlScheme(Uri.parse(url));
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (pendingAction != null) {
                    dispatchActionToWeb(pendingAction);
                    pendingAction = null;
                }
            }
        });

        loadAppContent(null);
    }

    private boolean handleUrlScheme(Uri uri) {
        if (uri == null) return false;
        String scheme = uri.getScheme();

        // 1. Skema internal dasbor
        if ("dasbor".equalsIgnoreCase(scheme)) {
            String host = uri.getHost();
            if ("sync".equalsIgnoreCase(host) || "/sync".equals(uri.getPath())) {
                updateWidgetFromUri(uri);
                return true;
            }
            if ("auth-callback".equalsIgnoreCase(host) || "/auth-callback".equals(uri.getPath())) {
                handleAuthCallbackUri(uri);
                return true;
            }
            String action = uri.getQueryParameter("action");
            if (action == null) action = host;
            if (action != null && !action.isEmpty()) {
                dispatchActionToWeb(action);
            }
            return true;
        }

        // 2. Skema file lokal
        if ("file".equalsIgnoreCase(scheme)) {
            return false;
        }

        // 3. Link eksternal (WA, Tel, Mail, Maps, atau Web Luar)
        try {
            Intent externalIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(externalIntent);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Gagal membuka link eksternal: " + uri, e);
            return false;
        }
    }

    private void loadAppContent(String targetAction) {
        File otaDir = new File(getFilesDir(), "ota_bundle");
        File otaFile = new File(otaDir, "index.html");

        if (!otaFile.exists() || otaFile.length() < 50000) {
            copyAssetToFile("index.html", otaFile);
        }

        String targetUrl;
        if (otaFile.exists() && otaFile.length() > 50000) {
            targetUrl = "file://" + otaFile.getAbsolutePath();
            Log.i(TAG, "Memuat bundle OTA: " + targetUrl);
        } else {
            targetUrl = "file:///android_asset/index.html";
            Log.i(TAG, "Memuat asset bawaan APK: " + targetUrl);
        }

        if (targetAction != null && !targetAction.isEmpty()) {
            pendingAction = targetAction;
        }

        webView.loadUrl(targetUrl);
    }

    private void copyAssetToFile(String assetName, File targetFile) {
        try {
            File parent = targetFile.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            try (InputStream is = getAssets().open(assetName);
                 FileOutputStream fos = new FileOutputStream(targetFile)) {
                byte[] buffer = new byte[8192];
                int read;
                while ((read = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, read);
                }
            }
            Log.i(TAG, "Berhasil menyalin asset " + assetName + " ke " + targetFile.getAbsolutePath());
        } catch (Exception e) {
            Log.e(TAG, "Gagal menyalin asset " + assetName, e);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent == null) return;
        Uri data = intent.getData();

        if (data != null && ("sync".equals(data.getHost()) || "/sync".equals(data.getPath()))) {
            updateWidgetFromUri(data);
            return;
        }

        if (data != null && ("auth-callback".equals(data.getHost()) || "/auth-callback".equals(data.getPath()))) {
            handleAuthCallbackUri(data);
            return;
        }

        String action = null;
        if (intent.hasExtra("action")) {
            action = intent.getStringExtra("action");
        } else if (data != null) {
            action = data.getQueryParameter("action");
            if (action == null && data.getLastPathSegment() != null && !"home".equals(data.getLastPathSegment())) {
                action = data.getLastPathSegment();
            } else if (action == null && data.getHost() != null && !"home".equals(data.getHost())) {
                action = data.getHost();
            }
        }

        if (action != null && !action.isEmpty()) {
            if (webView != null && webView.getProgress() >= 100) {
                dispatchActionToWeb(action);
            } else {
                pendingAction = action;
            }
        }
    }

    private void updateWidgetFromUri(Uri data) {
        String saldo = data.getQueryParameter("saldo");
        String taskCount = data.getQueryParameter("taskCount");
        String topTask = data.getQueryParameter("topTask");

        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        if (saldo != null && !saldo.isEmpty()) editor.putString("cached_saldo", saldo);
        if (taskCount != null && !taskCount.isEmpty()) editor.putString("cached_task_count", taskCount);
        if (topTask != null && !topTask.isEmpty()) editor.putString("cached_top_task", topTask);
        editor.apply();

        DasborWidgetProvider.updateAllWidgets(this);
        TaskWidgetProvider.updateAllWidgets(this);
    }

    private void dispatchActionToWeb(String action) {
        if (webView == null) return;
        mainHandler.post(() -> {
            String script = String.format("if (typeof handleNativeAction === 'function') { handleNativeAction('%s'); }", action);
            webView.evaluateJavascript(script, null);
        });
    }

    private void handleAuthCallbackUri(Uri uri) {
        String idToken = uri.getQueryParameter("idToken");
        String name = uri.getQueryParameter("name");
        String email = uri.getQueryParameter("email");
        String photo = uri.getQueryParameter("photo");
        String uid = uri.getQueryParameter("uid");

        if (idToken == null) idToken = "";
        if (name == null) name = "Pengguna";
        if (email == null) email = "";
        if (photo == null) photo = "";
        if (uid == null) uid = "";

        final String finalIdToken = idToken;
        final String finalName = name;
        final String finalEmail = email;
        final String finalPhoto = photo;
        final String finalUid = uid;

        mainHandler.post(() -> {
            if (webView == null) return;
            String script = String.format(
                    "if (typeof handleAuthBridgeSuccess === 'function') { handleAuthBridgeSuccess('%s', '%s', '%s', '%s', '%s'); }",
                    escapeJsString(finalIdToken),
                    escapeJsString(finalName),
                    escapeJsString(finalEmail),
                    escapeJsString(finalPhoto),
                    escapeJsString(finalUid)
            );
            webView.evaluateJavascript(script, null);
        });
    }

    private String escapeJsString(String input) {
        if (input == null) return "";
        return input.replace("\\", "\\\\")
                    .replace("'", "\\'")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r");
    }

    // ==========================================
    // SISTEM PEMBARUAN OTOMATIS OTA (OVER-THE-AIR)
    // ==========================================
    public void checkForOtaUpdate(boolean isUserTriggered) {
        backgroundExecutor.execute(() -> {
            try {
                if (!isNetworkAvailable()) {
                    if (isUserTriggered) {
                        notifyWebDynamicIsland("Pembaruan OTA", "Tidak ada koneksi internet", "fas fa-wifi-slash", "bg-rose-500/20 text-rose-400");
                    }
                    return;
                }

                if (isUserTriggered) {
                    notifyWebDynamicIsland("Pembaruan OTA", "Memeriksa versi terbaru...", "fas fa-sync fa-spin", "bg-primary-500/20 text-primary-400");
                }

                URL url = new URL(OTA_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(8000);
                conn.setReadTimeout(12000);
                conn.connect();

                int code = conn.getResponseCode();
                if (code != HttpURLConnection.HTTP_OK) {
                    if (isUserTriggered) {
                        notifyWebDynamicIsland("Pembaruan OTA", "Gagal menghubungi server (" + code + ")", "fas fa-exclamation-circle", "bg-rose-500/20 text-rose-400");
                    }
                    return;
                }

                StringBuilder sb = new StringBuilder();
                try (InputStream is = conn.getInputStream();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }

                String downloadedContent = sb.toString();

                // Validasi Integritas File HTML
                if (downloadedContent.length() < 50000 || !downloadedContent.contains("</html>")) {
                    Log.w(TAG, "File OTA yang diunduh tidak valid atau terpotong!");
                    if (isUserTriggered) {
                        notifyWebDynamicIsland("Pembaruan OTA", "File pembaruan tidak valid", "fas fa-exclamation-triangle", "bg-rose-500/20 text-rose-400");
                    }
                    return;
                }

                String newHash = calculateMD5(downloadedContent);
                SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                String currentHash = prefs.getString(KEY_OTA_HASH, "");

                // Cek apakah konten benar-benar baru
                if (newHash.equalsIgnoreCase(currentHash)) {
                    Log.i(TAG, "OTA: Aplikasi sudah menggunakan versi terbaru (" + newHash + ")");
                    if (isUserTriggered) {
                        notifyWebDynamicIsland("Pembaruan OTA", "Aplikasi Anda sudah versi terbaru! ✨", "fas fa-check-circle", "bg-emerald-500/20 text-emerald-400");
                    }
                    return;
                }

                // Tulis ke file bundle internal secara aman (Atomic Write)
                File otaDir = new File(getFilesDir(), "ota_bundle");
                if (!otaDir.exists()) otaDir.mkdirs();

                File tempFile = new File(otaDir, "temp_index.html");
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    fos.write(downloadedContent.getBytes(StandardCharsets.UTF_8));
                }

                File targetFile = new File(otaDir, "index.html");
                if (tempFile.renameTo(targetFile) || (targetFile.delete() && tempFile.renameTo(targetFile))) {
                    prefs.edit()
                            .putString(KEY_OTA_HASH, newHash)
                            .putLong("ota_last_sync", System.currentTimeMillis())
                            .apply();

                    Log.i(TAG, "OTA: Pembaruan berhasil diterapkan! Hash: " + newHash);

                    mainHandler.post(() -> {
                        notifyWebDynamicIsland("Pembaruan OTA", "Fitur baru berhasil diunduh! Memuat ulang...", "fas fa-sparkles", "bg-purple-500/20 text-purple-400");
                        mainHandler.postDelayed(() -> loadAppContent(null), 1200);
                    });
                }

            } catch (Exception e) {
                Log.e(TAG, "Error saat memeriksa OTA update", e);
                if (isUserTriggered) {
                    notifyWebDynamicIsland("Pembaruan OTA", "Gagal memeriksa pembaruan", "fas fa-exclamation-circle", "bg-rose-500/20 text-rose-400");
                }
            }
        });
    }

    private void notifyWebDynamicIsland(String title, String message, String icon, String colorClass) {
        mainHandler.post(() -> {
            if (webView == null) return;
            String js = String.format(
                    "if (typeof triggerDynamicIsland === 'function') { triggerDynamicIsland('%s', '%s', '%s', '%s'); }",
                    title, message, icon, colorClass
            );
            webView.evaluateJavascript(js, null);
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;
        NetworkInfo net = cm.getActiveNetworkInfo();
        return net != null && net.isConnected();
    }

    private String calculateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return String.valueOf(input.hashCode());
        }
    }

    // ==========================================
    // JAVASCRIPT NATIVE BRIDGE
    // ==========================================
    public class DasborBridge {
        @JavascriptInterface
        public void updateWidgetData(String saldo, String taskCount, String topTask) {
            SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
            if (saldo != null) editor.putString("cached_saldo", saldo);
            if (taskCount != null) editor.putString("cached_task_count", taskCount);
            if (topTask != null) editor.putString("cached_top_task", topTask);
            editor.apply();

            DasborWidgetProvider.updateAllWidgets(MainActivity.this);
            TaskWidgetProvider.updateAllWidgets(MainActivity.this);
        }

        @JavascriptInterface
        public String getAppVersion() {
            return "v33.14.OTA";
        }

        @JavascriptInterface
        public boolean isStandaloneApk() {
            return true;
        }

        @JavascriptInterface
        public void checkOtaUpdate() {
            MainActivity.this.checkForOtaUpdate(true);
        }

        @JavascriptInterface
        public void launchGoogleAuth() {
            mainHandler.post(() -> {
                String authUrl = "https://habielmaulanaaa-svg.github.io/dasbor-pribadi/auth-bridge.html";
                try {
                    CustomTabColorSchemeParams colorParams = new CustomTabColorSchemeParams.Builder()
                            .setToolbarColor(Color.parseColor("#0e1621"))
                            .setNavigationBarColor(Color.parseColor("#0e1621"))
                            .build();

                    CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                            .setDefaultColorSchemeParams(colorParams)
                            .setShowTitle(true)
                            .setUrlBarHidingEnabled(true)
                            .build();

                    customTabsIntent.launchUrl(MainActivity.this, Uri.parse(authUrl));
                } catch (Exception e) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl));
                    startActivity(browserIntent);
                }
            });
        }

        @JavascriptInterface
        public void setStorageItem(String key, String value) {
            if (key == null) return;
            getSharedPreferences("dasbor_storage_bridge", MODE_PRIVATE)
                    .edit()
                    .putString(key, value)
                    .apply();
        }

        @JavascriptInterface
        public String getStorageItem(String key) {
            if (key == null) return null;
            return getSharedPreferences("dasbor_storage_bridge", MODE_PRIVATE)
                    .getString(key, null);
        }

        @JavascriptInterface
        public void removeStorageItem(String key) {
            if (key == null) return;
            getSharedPreferences("dasbor_storage_bridge", MODE_PRIVATE)
                    .edit()
                    .remove(key)
                    .apply();
        }

        @JavascriptInterface
        public void reloadApp() {
            mainHandler.post(() -> MainActivity.this.loadAppContent(null));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        backgroundExecutor.shutdown();
        super.onDestroy();
    }
}
