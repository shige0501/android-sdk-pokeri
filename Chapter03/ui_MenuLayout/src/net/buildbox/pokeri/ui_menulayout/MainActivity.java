package net.buildbox.pokeri.ui_menulayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	// メニュー識別用のID
	private static final int MENU_SAMPLE = Menu.FIRST;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューのレイアウトファイル読み込み
		getMenuInflater().inflate(R.menu.main, menu);
		
		// 動的にメニューを追加
		MenuItem item = menu.add(Menu.NONE, MENU_SAMPLE, 600, "動的なメニュー");
		// アイコンの指定
		item.setIcon(android.R.drawable.ic_menu_camera);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		return true;
	}
	
	// メニューが選択された時の処理
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_item1:
	    	Toast.makeText(this, "アイテム１の選択", Toast.LENGTH_SHORT).show();
	    	return true;
	    case MENU_SAMPLE:
	    	Toast.makeText(this, "動的メニューの選択", Toast.LENGTH_SHORT).show();
	        return true;
	    default:
	        break;	
	    }
	    
	    return super.onOptionsItemSelected(item);
	}

}
