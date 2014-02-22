package net.buildbox.pokeri.window_configuration;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 画面の向きを表示
		Resources resources = getResources();
		Configuration config = resources.getConfiguration();
		String strOrientation = "";
		if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
			strOrientation = "縦方向";
		} else if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			strOrientation = "横方向";
		}
		Toast.makeText(this,
				"画面の向きは、" + strOrientation,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
