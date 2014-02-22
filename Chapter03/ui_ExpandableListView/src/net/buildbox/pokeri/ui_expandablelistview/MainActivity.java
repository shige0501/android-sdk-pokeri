package net.buildbox.pokeri.ui_expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 親要素のリスト生成
		ArrayList<HashMap<String, String>> groupData = new ArrayList<HashMap<String, String>>();
		
		// 親要素の項目生成
		HashMap<String, String> mapGroupItem = new HashMap<String, String>();
		mapGroupItem.put("book", "書籍");
		
		// 親要素のリストに項目追加
		groupData.add(mapGroupItem);
		
		// 子要素のリスト生成
		ArrayList<ArrayList<HashMap<String, String>>> childData =
				new ArrayList<ArrayList<HashMap<String, String>>>();
		
		// 子要素の項目生成
		ArrayList<HashMap<String, String>> childGroup = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> mapChildItem1 = new HashMap<String, String>();
		mapChildItem1.put("book", "Android SDKポケットリファレンス");
		mapChildItem1.put("publish", "技術評論社");
		HashMap<String, String> mapChildItem2 = new HashMap<String, String>();
		mapChildItem2.put("book", "Software Design");
		mapChildItem2.put("publish", "技術評論社");
		HashMap<String, String> mapChildItem3 = new HashMap<String, String>();
		mapChildItem3.put("book", "初めてのAndroid 第3版");
		mapChildItem3.put("publish", "オライリージャパン");
		
		// 子要素をグループ化
		childGroup.add(mapChildItem1);
		childGroup.add(mapChildItem2);
		childGroup.add(mapChildItem3);
		
		// 子要素をリストに追加
		childData.add(childGroup);
		
		// アダプタの生成
		SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
				this,
				groupData,
				android.R.layout.simple_expandable_list_item_1,
				new String[] {"book"},
				new int[] {android.R.id.text1},
				childData,
				android.R.layout.simple_expandable_list_item_1,
				new String[] {"book"},
				new int[] {android.R.id.text1});
		
		// アダプタの設定
		ExpandableListView expandableListView =
				(ExpandableListView) findViewById(R.id.expandableListView);
		expandableListView.setAdapter(adapter);
		
		// 子要素がクリックされた時の処理
		expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// 出版社の表示
				SimpleExpandableListAdapter adapter =
						(SimpleExpandableListAdapter) parent.getExpandableListAdapter();
				HashMap<String, String> childData =
						(HashMap<String, String>)adapter.getChild(groupPosition, childPosition);
				Toast.makeText(getApplicationContext(), "出版社は『" + 
						childData.get("publish") + "』です。", Toast.LENGTH_SHORT).show();
				
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
