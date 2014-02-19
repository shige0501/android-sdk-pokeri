package net.buildbox.pokeri.media_soundpool;

import java.util.ArrayList;
import java.util.Random;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	SoundPool mPool = null;
	boolean mCompleteFlag = false;
	ArrayList<Integer> arraySound = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		//　音楽ファイルの読み込み
		arraySound = new ArrayList<Integer>();
		mPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		arraySound.add(0, mPool.load(this, R.raw.cat, 1));
		arraySound.add(1, mPool.load(this, R.raw.crows, 1));
		arraySound.add(2, mPool.load(this, R.raw.door_chime, 1));
		arraySound.add(3, mPool.load(this, R.raw.knocking_iron_door1, 1));
		arraySound.add(4, mPool.load(this, R.raw.station_announce, 1));
		mPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
				if (status == 0) {
					// 音楽ファイルの読み込みが完了
					Toast.makeText(getApplicationContext(), sampleId + "の読み込みが完了", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	public void onSoundPool(View v) {
		// 乱数の生成
		Random random = new Random();
		int r = random.nextInt(5);
		
		// 音楽の再生
		mPool.play(arraySound.get(r), 1.0f, 1.0f, 1, 0, 1.0f);
	}
	
	@Override
	protected void onPause() {
		if (mPool != null) {
			mPool.release();
		}
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
