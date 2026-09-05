package com.dasbor.pribadi;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class DasborBarWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dasbor_widget_bar_layout);

        // 1. Klik area logo / widget -> Buka Beranda Dasbor
        views.setOnClickPendingIntent(R.id.widget_bar_root, createActionPendingIntent(context, null, 200));
        views.setOnClickPendingIntent(R.id.btn_bar_home, createActionPendingIntent(context, null, 201));

        // 2. Tombol Aksi Cepat + Pemasukan
        views.setOnClickPendingIntent(R.id.btn_bar_income, createActionPendingIntent(context, "pemasukan", 202));

        // 3. Tombol Aksi Cepat - Pengeluaran
        views.setOnClickPendingIntent(R.id.btn_bar_expense, createActionPendingIntent(context, "pengeluaran", 203));

        // 4. Tombol Catatan & Belanjaan
        views.setOnClickPendingIntent(R.id.btn_bar_notes, createActionPendingIntent(context, "catatan", 204));

        // 5. Tombol Kalkulator Impian
        views.setOnClickPendingIntent(R.id.btn_bar_calc, createActionPendingIntent(context, "kalkulator", 205));

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