package net.buildbox.pokeri.app_navigationdropdown;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ActionBarの取得
		ActionBar actionBar = getSupportActionBar();
		// ドロップダウンリストモードに変更
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		// ドロップダウンリストに表示するアダプタの設定
		SpinnerAdapter adapter = ArrayAdapter.createFromResource(
				this,
				R.array.action_list,
				android.R.layout.simple_spinner_dropdown_item);
		actionBar.setListNavigationCallbacks(adapter, mOnNavigationListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	ActionBar.OnNavigationListener mOnNavigationListener = new ActionBar.OnNavigationListener() {
		
		@Override
		public boolean onNavigationItemSelected(int itemPosition, long itemId) {
			switch (itemPosition) {
			case 1:	// トーストの表示
				Toast.makeText(getApplicationContext(), "トーストの表示", Toast.LENGTH_SHORT).show();
				break;
			case 2:	// 技術評論社のサイトの表示
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gihyo.co.jp/"));
				startActivity(intent);
				break;
			case 3:	// アクティビティの終了処理
				finish();
				break;
			}
			return false;
		}
	};
}
