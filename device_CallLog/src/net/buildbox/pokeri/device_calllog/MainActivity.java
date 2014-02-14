package net.buildbox.pokeri.device_calllog;

import android.os.Bundle;
import android.provider.CallLog;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends FragmentActivity
				implements LoaderCallbacks<Cursor> {
	private SimpleCursorAdapter mAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// リストビューの設定
		mAdapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_expandable_list_item_2,
				null,
				new String[] {CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME},
				new int[] {android.R.id.text1, android.R.id.text2}, 0);
		ListView lv_CallLog = (ListView) findViewById(R.id.lv_CallLog);
		lv_CallLog.setAdapter(mAdapter);
		
		// Loaderの初期化
		getSupportLoaderManager().initLoader(0, null, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// 通話履歴をCursorLoaderで日付の降順で生成
		return new CursorLoader(this,
				CallLog.Calls.CONTENT_URI,
				null,
				null,
				null,
				CallLog.Calls.DEFAULT_SORT_ORDER);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		mAdapter.swapCursor(data);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		mAdapter.swapCursor(null);
	}
}
