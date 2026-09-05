package com.dasbor.pribadi;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class DasborWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dasbor_widget_layout);

        // 1. Klik seluruh kartu widget -> Buka Beranda Dasbor
        views.setOnClickPendingIntent(R.id.widget_root, createActionPendingIntent(context, null, 100));

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