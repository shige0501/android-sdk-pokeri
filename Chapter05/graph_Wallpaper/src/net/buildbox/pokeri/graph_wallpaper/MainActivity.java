package net.buildbox.pokeri.graph_wallpaper;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.app.WallpaperManager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	WallpaperManager mWallpaperManager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mWallpaperManager = WallpaperManager.getInstance(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClickEvent(View v) {
		// 壁紙の設定
		try {
			mWallpaperManager.setResource(R.drawable.ic_launcher);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
