package net.buildbox.pokeri.window_brightness;

import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 画面の明るさを取得
		String strBrightness = Settings.System.getString(
				getContentResolver(),
				Settings.System.SCREEN_BRIGHTNESS);
		
		TextView tv_brightness = (TextView) findViewById(R.id.tv_brightness);
		tv_brightness.setText("明るさ： " + strBrightness );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
