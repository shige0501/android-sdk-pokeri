package net.buildbox.pokeri.media_audiomanager;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        // 着信音量の取得
    	AudioManager audioMgr = (AudioManager) getSystemService(AUDIO_SERVICE);
        int ringVolume = audioMgr.getStreamVolume(AudioManager.STREAM_RING);
    	TextView tv_volume = (TextView) findViewById(R.id.tv_volume);
        tv_volume.setText(String.valueOf(ringVolume));

        // マイナスボタン押下時の処理
        Button btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AudioManager audioMgr = (AudioManager) getSystemService(AUDIO_SERVICE);
				TextView tv_volume = (TextView) findViewById(R.id.tv_volume);

				// 着信音の取得
				int ringVolume = audioMgr.getStreamVolume(AudioManager.STREAM_RING);
				// 着信音の設定（ボリュームを1下げる）
				audioMgr.setStreamVolume(AudioManager.STREAM_RING, --ringVolume, AudioManager.FLAG_SHOW_UI);
				tv_volume.setText(String.valueOf(ringVolume));
			}
		});
        
        // プラスボタン押下時の処理
        Button btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AudioManager audioMgr = (AudioManager) getSystemService(AUDIO_SERVICE);
				TextView tv_volume = (TextView) findViewById(R.id.tv_volume);

				// 着信音の取得
				int ringVolume = audioMgr.getStreamVolume(AudioManager.STREAM_RING);
				// 着信音の設定（ボリュームを１上げる）
				audioMgr.setStreamVolume(AudioManager.STREAM_RING, ++ringVolume, AudioManager.FLAG_SHOW_UI);
				tv_volume.setText(String.valueOf(ringVolume));
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
