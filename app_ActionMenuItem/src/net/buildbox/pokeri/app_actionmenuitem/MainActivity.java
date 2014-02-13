package net.buildbox.pokeri.app_actionmenuitem;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private static final int MENU_SAMPLE = Menu.FIRST;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューのレイアウトファイルを読み込む
		getMenuInflater().inflate(R.menu.main, menu);
		
		// 動的にメニューを追加
		MenuItem item = menu.add(Menu.NONE, MENU_SAMPLE, 200, "動的なメニュー");
		MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_SAMPLE:
			Toast.makeText(this, "動的なメニューの選択", Toast.LENGTH_SHORT).show();
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}
}
