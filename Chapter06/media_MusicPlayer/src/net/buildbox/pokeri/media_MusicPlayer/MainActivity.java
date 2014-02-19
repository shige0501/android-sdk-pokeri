package net.buildbox.pokeri.media_MusicPlayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	MediaPlayer mPlayer = null;
	
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

	public void onClickEvent(View v) {
		// 音楽データの読み込み
		mPlayer = MediaPlayer.create(this, R.raw.waltz);
		mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				// 読み込みが完了したら、再生を開始
				mp.start();
			}
		});

	}
	
	@Override
	protected void onPause() {
		if (mPlayer != null) {
			mPlayer.stop();
			mPlayer.release();
		}
		
		super.onPause();
	}
}
