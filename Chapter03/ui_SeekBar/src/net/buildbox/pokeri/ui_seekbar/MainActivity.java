package net.buildbox.pokeri.ui_seekbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		
		setContentView(R.layout.activity_main);

		// シークバーの最大値と初期値を設定
		SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
		seekBar.setMax(100); // 最大値
		seekBar.setProgress(0); // 初期値

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			// トラッキング開始時の処理
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// タイトルバーにプログレスバー（Indeterminate)の表示
				setProgressBarIndeterminateVisibility(true);
			}

			// トラッキング中の処理
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromTouch) {
				TextView tvProgress = (TextView) findViewById(R.id.tvProgress);
				tvProgress.setText(progress + "%...");
			}

			// トラッキング終了時の処理
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// タイトルバー上のプログレスバー（Indeterminate）の非表示化
				setProgressBarIndeterminateVisibility(false);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
