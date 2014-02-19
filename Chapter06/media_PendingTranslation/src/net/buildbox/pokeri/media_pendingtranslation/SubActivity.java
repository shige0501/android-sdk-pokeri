package net.buildbox.pokeri.media_pendingtranslation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SubActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void finish() {
		super.finish();
		
		// 画面スライドのアニメーション設定
		overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	}
}
