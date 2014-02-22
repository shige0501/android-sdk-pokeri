package net.buildbox.pokeri.window_titleicon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// タイトルの左右にアイコン表示を指定
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		requestWindowFeature(Window.FEATURE_RIGHT_ICON);
		
		setContentView(R.layout.activity_main);
		
		// タイトルの左右に表示するアイコンの指定
		getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.ic_launcher);
		getWindow().setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON, R.drawable.ic_launcher);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// タイトルバー上のアイコンの透過度を指定
		getWindow().setFeatureDrawableAlpha(Window.FEATURE_LEFT_ICON, 40);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		// タイトルバー上のアイコンの透過度を解除
		getWindow().setFeatureDrawableAlpha(Window.FEATURE_LEFT_ICON, 255);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
