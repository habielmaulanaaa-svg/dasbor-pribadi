package com.dasbor.pribadi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://habielmaulanaaa-svg.github.io/dasbor-pribadi/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        String targetUrl = BASE_URL;
        String action = null;

        if (intent != null) {
            // Cek jika dipanggil lewat intent extra dari Widget
            if (intent.hasExtra("action")) {
                action = intent.getStringExtra("action");
            } 
            // Cek jika dipanggil lewat deep-link URI dasbor://?action=...
            else if (intent.getData() != null) {
                Uri data = intent.getData();
                action = data.getQueryParameter("action");
                if (action == null && data.getHost() != null) {
                    action = data.getHost();
                }
            }
        }

        if (action != null && !action.isEmpty()) {
            targetUrl = BASE_URL + "?action=" + action;
        }

        // Luncurkan Chrome Custom Tabs (OTA, Google Auth, Service Worker didukung penuh)
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

            customTabsIntent.launchUrl(this, Uri.parse(targetUrl));
        } catch (Exception e) {
            // Fallback jika browser default belum siap
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(targetUrl));
            startActivity(browserIntent);
        }

        finish();
    }
}