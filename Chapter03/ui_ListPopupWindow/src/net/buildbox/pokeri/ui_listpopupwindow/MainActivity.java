package net.buildbox.pokeri.ui_listpopupwindow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListPopupWindow mListPopup = null;

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

	// リストポップアップウィンドウの表示
	public void showListPopupWindow(View v) {
		// ListPopupWindowの生成
		mListPopup = new ListPopupWindow(this);
		
		// Adapterの設定
		String[] fruits = {"Apple", "Orange", "Grape", "Mango"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, fruits);
		mListPopup.setAdapter(adapter);
		
		// リスト上のアイテムがクリックされた時の処理を行うリスナー登録
		mListPopup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			// リスト上のアイテムがクリックされた時の処理
			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position,
					long id) {
				String fruit = (String) adapter.getItemAtPosition(position);
				Toast.makeText(getApplicationContext(), fruit + "が選択されました。", Toast.LENGTH_SHORT).show();
				mListPopup.dismiss();
			}
		});
		
		// 紐付けるビューの設定
		Button btnPopup = (Button) findViewById(R.id.btnPopup);
		mListPopup.setAnchorView(btnPopup);
		
		// ポップアップの表示
		mListPopup.show();
	}
}
