package net.buildbox.pokeri.provider_calendar;

import java.util.Calendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.format.Time;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends FragmentActivity 
		implements LoaderManager.LoaderCallbacks<Cursor> {
	
	private SimpleCursorAdapter mAdapter = null;
	
	// クエリで取得する項目
	private String[] CALENDAR_PROJECTION = new String[] {
			CalendarContract.Events._ID,
			CalendarContract.Events.TITLE,
			CalendarContract.Events.DESCRIPTION
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mAdapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2,
				null,
				new String[] {CalendarContract.Events.TITLE, CalendarContract.Events.DESCRIPTION},
				new int[] {android.R.id.text1, android.R.id.text2}, 0);
		
		ListView lv_calendar = (ListView) findViewById(R.id.lv_calendar);
		lv_calendar.setAdapter(mAdapter);
		
		// Loaderの初期化
		getSupportLoaderManager().initLoader(0, null, this);
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// カレンダーのイベントをコンテンツプロバイダから取得するCursorLoaderの生成
		return new CursorLoader(this,
				CalendarContract.Events.CONTENT_URI,
				CALENDAR_PROJECTION,
				null,
				null,
				CalendarContract.Events.DTSTART + " desc");
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// カレンダーのイベントを読み込んだデータをSimpleCursorAdapterに設定
		mAdapter.swapCursor(data);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		// SimpleCursorAdapterの中身を空に設定
		mAdapter.swapCursor(null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_add:
			// イベントの追加
			addCalendarEvent();
			return true;
			
		case R.id.action_update:
			// イベントの更新
			updateCalendarEvent();
			return true;
			
		case R.id.action_delete:
			// イベントの削除
			deleteCalendarEvent();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addCalendarEvent() {
		// イベント開始・終了時間の設定
		long startMillis = 0;
		long endMillis = 0;
		Calendar calStart = Calendar.getInstance();
		calStart.set(2012, 10, 26, 9, 0);
		startMillis = calStart.getTimeInMillis();
		Calendar calEnd = Calendar.getInstance();
		calEnd.set(2012, 10, 26, 11, 0);
		endMillis = calEnd.getTimeInMillis();
		
		// イベントの登録
		ContentResolver cr = getContentResolver();
		ContentValues values = new ContentValues();
		values.put(CalendarContract.Events.DTSTART, startMillis);
		values.put(CalendarContract.Events.DTEND, endMillis);
		values.put(CalendarContract.Events.EVENT_TIMEZONE, Time.getCurrentTimezone());
		values.put(CalendarContract.Events.TITLE, "Androidポケリ");
		values.put(CalendarContract.Events.DESCRIPTION, "Androidポケリイベント");
		values.put(CalendarContract.Events.CALENDAR_ID, 1);
		Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
		
		getSupportLoaderManager().restartLoader(0, null, this);
	}
	
	public void updateCalendarEvent() {
		// イベントの更新
		ContentResolver cr = getContentResolver();
		ContentValues values = new ContentValues();
		values.put(CalendarContract.Events.DESCRIPTION, "Androidポケリイベント更新！");
		values.put(CalendarContract.Events.CALENDAR_ID, 1);
		cr.update(CalendarContract.Events.CONTENT_URI,
				values, CalendarContract.Events.TITLE + " = 'Androidポケリ'", null);
		
		getSupportLoaderManager().restartLoader(0, null, this);
	}
	
	public void deleteCalendarEvent() {
		ContentResolver cr = getContentResolver();
		cr.delete(CalendarContract.Events.CONTENT_URI,
				CalendarContract.Events.TITLE + " = 'Androidポケリ'", null);
		
		getSupportLoaderManager().restartLoader(0, null, this);
	}
}
