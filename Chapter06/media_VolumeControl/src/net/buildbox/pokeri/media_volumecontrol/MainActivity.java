package net.buildbox.pokeri.media_volumecontrol;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// アプリ起動中のボリューム変更はアラームのみに設定
		setVolumeControlStream(AudioManager.STREAM_ALARM);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
