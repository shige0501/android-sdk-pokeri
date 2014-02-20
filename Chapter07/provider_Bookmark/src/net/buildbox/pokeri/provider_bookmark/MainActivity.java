package net.buildbox.pokeri.provider_bookmark;

import android.os.Bundle;
import android.provider.Browser;
import android.provider.Browser.BookmarkColumns;
import android.support.v4.widget.SimpleCursorAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	// クエリで取得する項目
	private String[] BOOKMARK_PROJECTION = new String[] {
			BookmarkColumns._ID,
			BookmarkColumns.TITLE,
			BookmarkColumns.URL
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ブックマークの名前取得
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(Browser.BOOKMARKS_URI, BOOKMARK_PROJECTION, null, null, null);
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2,
				cursor,
				new String[] {BookmarkColumns.TITLE, BookmarkColumns.URL},
				new int[] {android.R.id.text1, android.R.id.text2}, 0);
		
		ListView lv_bookmark = (ListView) findViewById(R.id.lv_bookmark);
		lv_bookmark.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
