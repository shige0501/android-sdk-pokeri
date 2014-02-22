package net.buildbox.pokeri.ui_listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ImageView mIvFooter = null;		// フッタ表示用
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// フッター表示用ImageViewの生成
		mIvFooter = new ImageView(this);
		mIvFooter.setImageDrawable(getResources()
				.getDrawable(android.R.drawable.star_big_on));
		
		ListView listView = (ListView) findViewById(android.R.id.list);
		
		// リストが空の時のビューの設定
		LayoutInflater inflater = getLayoutInflater();
		View emptyView = inflater.inflate(
				R.layout.activity_main,
				(ViewGroup) findViewById(android.R.id.empty));
		listView.setEmptyView(emptyView);
		
		// リストビューのアイテムがクリックされた時の処理
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
		        ListView lv = (ListView)parent;
		        Toast.makeText(getApplicationContext(),
		                (String)lv.getItemAtPosition(position),
		                Toast.LENGTH_SHORT).show();
			}
		});
		
		// スクロールの最後尾検知
		listView.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// スクロールの状態が変化した時の通知
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				ListView lv = (ListView) view;
				// スクロール時の最終行を検知
				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					if (lv.getFooterViewsCount() == 0) {
						// フッタービューの追加
						lv.addFooterView(mIvFooter);
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューの読み込み
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		ListView lv = (ListView) findViewById(android.R.id.list);

		switch (item.getItemId()) {
		case R.id.menu_load:
			// リストビューの読み込み
			String[] language = { "C/C++", "Objective-C", "Fortran",
					"Java", "Scala", "Basic", "Ruby", "JavaScript",
					"Python", "PHP", "C#", "COBOL", "LISP",	"Scheme",
					"Haskell", "Erlang", "ASP", "HTML" };
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					this, android.R.layout.simple_list_item_1, language);

			// アダプタの設定
			lv.setAdapter(adapter);
			return true;
			
		case R.id.menu_position:
			// 最終項目の表示
			lv.setSelection(lv.getCount() - 1);
			return true;
			
		case R.id.menu_removeFooterView:
			// フッタービューの削除
			lv.removeFooterView(mIvFooter);
			return true;
		}
		
		return super.onMenuItemSelected(featureId, item);
	}
}
