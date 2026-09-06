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

public class TaskWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    public static void updateAllWidgets(Context context) {
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisWidget = new ComponentName(context, TaskWidgetProvider.class);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
            for (int id : appWidgetIds) {
                updateAppWidget(context, appWidgetManager, id);
            }
        } catch (Exception ignored) {}
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dasbor_widget_task_layout);

        SharedPreferences prefs = context.getSharedPreferences("dasbor_prefs", Context.MODE_PRIVATE);
        String taskCount = prefs.getString("cached_task_count", "0");
        String topTask = prefs.getString("cached_top_task", "Semua tugas hari ini selesai ✨");

        views.setTextViewText(R.id.tv_widget_task_badge, taskCount + " Tugas");
        views.setTextViewText(R.id.tv_widget_top_task, topTask);

        // Intent Beranda & Catatan
        PendingIntent homeIntent = createActionPendingIntent(context, null, 300);
        PendingIntent notesIntent = createActionPendingIntent(context, "catatan", 301);

        views.setOnClickPendingIntent(R.id.widget_task_root, homeIntent);
        views.setOnClickPendingIntent(R.id.widget_task_card, notesIntent);
        views.setOnClickPendingIntent(R.id.btn_widget_add_task, notesIntent);
        views.setOnClickPendingIntent(R.id.btn_widget_open_dasbor, homeIntent);

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
