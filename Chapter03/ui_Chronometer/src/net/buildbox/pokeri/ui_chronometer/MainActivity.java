package net.buildbox.pokeri.ui_chronometer;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを読み込む
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		Chronometer chronoMeter = (Chronometer) findViewById(R.id.chronoMeter);
		chronoMeter.setBase(SystemClock.elapsedRealtime());
		
		switch (item.getItemId()) {
		case R.id.menu_start:
		    chronoMeter.start();
		    return true;
		case R.id.menu_stop:
		    chronoMeter.stop();
		    chronoMeter.setBase(SystemClock.elapsedRealtime());
		    return true;
		}

		return super.onMenuItemSelected(featureId, item);
	}

}
