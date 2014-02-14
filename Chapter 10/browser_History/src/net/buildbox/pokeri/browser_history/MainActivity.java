package net.buildbox.pokeri.browser_history;

import android.os.Bundle;
import android.provider.Browser;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_ClearHistory:
			// 履歴のクリア
			Browser.clearHistory(getContentResolver());
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

}
