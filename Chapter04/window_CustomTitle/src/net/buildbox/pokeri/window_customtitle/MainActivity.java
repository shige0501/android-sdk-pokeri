package net.buildbox.pokeri.window_customtitle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        // タイトルバーを非表示にする
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		
		setContentView(R.layout.activity_main);
		
        // カスタマイズ用のレイアウトをタイトルバーに設定
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.disp_custom_title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
