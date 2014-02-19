package net.buildbox.pokeri.tel_readsms;

import android.net.Uri;
import android.os.Bundle;
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
	// SMSのURI
	private static final Uri SMS_URI = Uri.parse("content://sms/");
	
	private SimpleCursorAdapter mAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// リストビューの設定
		mAdapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_expandable_list_item_2,
				null,
				new String[] {"address", "body"},
				new int[] {android.R.id.text1, android.R.id.text2}, 0);
		ListView lv_sms = (ListView) findViewById(R.id.lv_sms);
		lv_sms.setAdapter(mAdapter);
		
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
		// 日付で降順に並べてSMSのデータをCursorLoaderで生成
		return new CursorLoader(this, SMS_URI, null, null, null, "date desc");
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
