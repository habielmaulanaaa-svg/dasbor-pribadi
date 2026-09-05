package com.dasbor.pribadi;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.RemoteViews;

public class DasborWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    public static void updateAllWidgets(Context context) {
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisWidget = new ComponentName(context, DasborWidgetProvider.class);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
            for (int id : appWidgetIds) {
                updateAppWidget(context, appWidgetManager, id);
            }
        } catch (Exception ignored) {}
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dasbor_widget_layout);

        // Baca saldo tersimpan dari SharedPreferences
        SharedPreferences prefs = context.getSharedPreferences("dasbor_prefs", Context.MODE_PRIVATE);
        String cachedSaldo = prefs.getString("cached_saldo", null);
        if (cachedSaldo != null && !cachedSaldo.isEmpty()) {
            views.setTextViewText(R.id.tv_widget_saldo, cachedSaldo);
            views.setTextViewText(R.id.tv_widget_status, "Tersinkronisasi Realtime");
        } else {
            views.setTextViewText(R.id.tv_widget_saldo, "Ketuk Cek Saldo");
            views.setTextViewText(R.id.tv_widget_status, "Buka aplikasi untuk sinkronisasi");
        }

        // 1. Klik seluruh kartu widget & kartu saldo -> Buka Beranda Dasbor
        PendingIntent homeIntent = createActionPendingIntent(context, null, 100);
        views.setOnClickPendingIntent(R.id.widget_root, homeIntent);
        views.setOnClickPendingIntent(R.id.widget_saldo_card, homeIntent);

        // 2. Tombol Aksi Cepat + Pemasukan
        views.setOnClickPendingIntent(R.id.btn_widget_income, createActionPendingIntent(context, "pemasukan", 101));

        // 3. Tombol Aksi Cepat - Pengeluaran
        views.setOnClickPendingIntent(R.id.btn_widget_expense, createActionPendingIntent(context, "pengeluaran", 102));

        // 4. Tombol Catatan & Belanjaan
        views.setOnClickPendingIntent(R.id.btn_widget_notes, createActionPendingIntent(context, "catatan", 103));

        // 5. Tombol Kalkulator Impian
        views.setOnClickPendingIntent(R.id.btn_widget_calc, createActionPendingIntent(context, "kalkulator", 104));

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    private static PendingIntent createActionPendingIntent(Context context, String action, int requestCode) {
        Intent intent = new Intent(context, MainActivity.class);
        if (action != null) {
            intent.putExtra("action", action);
            intent.setData(Uri.parse("dasbor://action/" + action));
        } else {
            intent.setData(Uri.parse("dasbor://home"));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return PendingIntent.getActivity(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
    }
}