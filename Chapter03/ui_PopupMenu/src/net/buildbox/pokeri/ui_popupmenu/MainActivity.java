package net.buildbox.pokeri.ui_popupmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showPopupMenu(View v) {
		// ポップアップメニューの生成
		PopupMenu popupMenu = new PopupMenu(this, v);
		
		// XMLのメニューリソースを設定
		popupMenu.getMenuInflater().inflate(R.menu.popup_main, popupMenu.getMenu());
		
		// ポップアップメニューがクリックされた時の処理を行う
		popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {             
		    @Override
		    public boolean onMenuItemClick(MenuItem item) {
		        switch (item.getItemId()) {
		        case R.id.menu_item1:
		        case R.id.menu_item2:
		        case R.id.menu_item3:
		        case R.id.menu_item4:
		        case R.id.menu_item5:
		            Toast.makeText(
		                    getApplicationContext(),
		                    item.getTitle() + " の選択",
		                    Toast.LENGTH_SHORT).show();
		            return true;
		        default:
		            break;
		        }
		        return false;
		    }
		});
		
		// ポップアップメニューの表示
		popupMenu.show();
	}
}
