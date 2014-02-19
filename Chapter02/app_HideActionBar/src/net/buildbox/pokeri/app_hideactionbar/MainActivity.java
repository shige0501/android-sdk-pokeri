package net.buildbox.pokeri.app_hideactionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends ActionBarActivity {

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

	public void onClickEvent(View v) {
		ActionBar actionBar = getSupportActionBar();
		// アクションバーの表示状態の取得
		if (actionBar.isShowing()) {
			// アクションバーを非表示
			actionBar.hide();
		} else {
			// アクションバーを表示
			actionBar.show();
		}
	}
}
