package net.buildbox.pokeri.app_navigationtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ActionBarの取得
		ActionBar actionBar = getSupportActionBar();
		// ActionBarをタブ表示に変更
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// タブの追加
		actionBar.addTab(actionBar.newTab().setText("タブ１")
				.setTabListener(mTabListener));
		actionBar.addTab(actionBar.newTab().setText("タブ２")
				.setTabListener(mTabListener));
		
		// 表示タブの選択
		actionBar.setSelectedNavigationItem(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	ActionBar.TabListener mTabListener = new ActionBar.TabListener() {
		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// タブが非選択となった時の処理を実装
		}
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// タブが選択された時に画面切り替え
			if (tab.getPosition() == 0) {
				Fragment mainFragment = new MainFragment();
				ft.replace(R.id.tab_root, mainFragment);
			} else {
				Fragment subFragment = new SubFragment();
				ft.replace(R.id.tab_root, subFragment);
			}
		}
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// タブが再度選択された時の処理を実装
		}
	};
}
