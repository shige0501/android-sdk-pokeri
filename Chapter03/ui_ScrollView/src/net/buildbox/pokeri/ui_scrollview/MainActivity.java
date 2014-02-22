package net.buildbox.pokeri.ui_scrollview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// スクロールバーの表示位置の設定
		ScrollView sv = (ScrollView) findViewById(R.id.scrollView);
		sv.setVerticalScrollbarPosition(ScrollView.SCROLLBAR_POSITION_LEFT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private int mCount = 0;
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if (item.getItemId() == R.id.menu_add) {
			// テキストの設定
			TextView textView = new TextView(getApplicationContext());
			textView.setText("追加したテキスト: " + ++mCount);
			textView.setTextSize(32.0f);
			textView.setTextColor(Color.BLACK);
			
			LinearLayout layoutTarget = (LinearLayout) findViewById(R.id.layoutTarget);
			layoutTarget.addView(textView);
			
			return true;
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
