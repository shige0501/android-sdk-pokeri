package net.buildbox.pokeri.ui_preferencefragment;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

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
		case R.id.action_settings:
    		// PreferenceActivityの呼び出し
    		Intent actIntent = new Intent(this, SettingPrefActivity.class);
    		startActivity(actIntent);

			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
