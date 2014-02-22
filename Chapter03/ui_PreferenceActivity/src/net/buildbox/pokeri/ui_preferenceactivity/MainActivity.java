package net.buildbox.pokeri.ui_preferenceactivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
    public void clickToast(View v) {
    	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
    	boolean bFlag = pref.getBoolean("key_checkbox", false);
    	
    	Toast.makeText(v.getContext(), "checkbox: " + bFlag, Toast.LENGTH_SHORT).show();
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
