package net.buildbox.pokeri.media_recorder;

import java.io.IOException;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	MediaRecorder mRecorder = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ToggleButton tbtn_record = (ToggleButton) findViewById(R.id.tbtn_record);
		tbtn_record.setOnCheckedChangeListener(mListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	CompoundButton.OnCheckedChangeListener mListener = new CompoundButton.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if (isChecked) {	// 録音開始
				mRecorder = new MediaRecorder();
				mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
				mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

				// 保存先の指定
				String path = Environment.getExternalStorageDirectory() + "/record_audio.mp4";
				mRecorder.setOutputFile(path);
				
				// 録音準備
				try {
					mRecorder.prepare();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 録音開始
				mRecorder.start();
			} else {
				// 録音の停止
				if (mRecorder != null) {
					mRecorder.stop();
					mRecorder.reset();
					mRecorder.release();
				}
			}
		}
	};
}
