package net.buildbox.pokeri.device_vibrator;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn_vibrate = (Button) findViewById(R.id.btn_vibrate);
        btn_vibrate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// バイブレーションの実行
				Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
				vibrator.vibrate(1000);	// 1秒実行
			}
		});
        
        Button btn_vibPattern = (Button) findViewById(R.id.btn_vibPattern);
        btn_vibPattern.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// バイブレーションのパターン実行
				Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
				long[] pattern = {
						100, 500,	// 停止：100ミリ秒、バイブレーション500ミリ秒
						100, 500,	// 停止：100ミリ秒、バイブレーション500ミリ秒
						100, 500,	// 停止：100ミリ秒、バイブレーション500ミリ秒
						100, 2000};	// 停止：100ミリ秒、バイブレーション2000ミリ秒
				vibrator.vibrate(pattern, -1);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
