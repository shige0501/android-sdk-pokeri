package net.buildbox.pokeri.ui_appwidget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
	private static final String TAG = "WidgetProvider";
	private static final String KEY_COUNT = "key_count";
	
	@Override
	public void onEnabled(Context context) {
		Log.d(TAG, "call onEnabled()");
		super.onEnabled(context);
	}
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.d(TAG, "call onUpdate()");
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		Log.d(TAG, "call onDeleted()");
		super.onDeleted(context, appWidgetIds);
	}
	
	@Override
	public void onDisabled(Context context) {
		Log.d(TAG, "call onDisabled()");
		super.onDisabled(context);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "call onReceive()");
		
		// サービスの起動
		Intent serviceIntent = new Intent(context, CountService.class);
		context.startService(serviceIntent);
		
		super.onReceive(context, intent);
	}
	
	public static class CountService extends Service {
		private static final String ACTION_COUNT = "net.buildbox.pokeri.action.ACTION_COUNT";
		
		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			super.onStartCommand(intent, flags, startId);
			
			// AppWidget上のボタンがクリックされた時の処理用Intent
			Intent clickIntent = new Intent();
			clickIntent.setAction(ACTION_COUNT);
			PendingIntent pendingIntent = PendingIntent.getService(this, 0, clickIntent, 0);
			RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.appwidget_main);
			remoteViews.setOnClickPendingIntent(R.id.btnUpdate, pendingIntent);
			
			// 受信したIntentの処理
			if (ACTION_COUNT.equals(intent.getAction())) {
				countUp();
				remoteViews.setTextViewText(R.id.tvMessage, "更新： " + getCount());
			}
			
			// AppWidgetの画面更新
			ComponentName widget = new ComponentName(this, WidgetProvider.class);
			AppWidgetManager widgetManager = AppWidgetManager.getInstance(this);
			widgetManager.updateAppWidget(widget, remoteViews);
			
			return START_STICKY;
		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
		
		private int getCount() {
			SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
			return pref.getInt(KEY_COUNT, 0);
		}
		
		private void countUp() {
			SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = pref.edit();
			editor.putInt(KEY_COUNT, getCount()+1);
			editor.commit();
		}
	}
}
