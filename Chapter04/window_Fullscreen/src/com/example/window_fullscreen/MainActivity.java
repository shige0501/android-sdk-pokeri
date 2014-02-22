package com.example.window_fullscreen;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ToggleButton tbtnFullscreen = (ToggleButton) findViewById(R.id.tbtnFullscreen);
		tbtnFullscreen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Window window = getWindow();
				if (isChecked) {	// チェック状態
					// フルスクリーン化する
					window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
				} else {			// 未チェック状態
					// フルスクリーンを解除する
					window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
