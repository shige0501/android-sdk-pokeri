package net.buildbox.pokeri.ui_contextmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// コンテキストメニューの登録
		ListView lvFruits = (ListView) findViewById(R.id.lvFruits);
		registerForContextMenu(lvFruits);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		getMenuInflater().inflate(R.menu.context_main, menu);
	}
	
	// コンテキストメニューが選択された時の処理
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu1:
		case R.id.menu2:
		case R.id.menu3:
			Toast.makeText(this, item.getTitle() + "の選択", Toast.LENGTH_SHORT).show();
			return true;
		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}
}
