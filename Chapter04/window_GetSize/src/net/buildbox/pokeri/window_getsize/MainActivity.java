package net.buildbox.pokeri.window_getsize;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        // 画面の幅、高さを取得する
        TextView tv_WindowSize = (TextView) findViewById(R.id.tv_WindowSize);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        tv_WindowSize.setText(
        		"幅：　" + dm.widthPixels
        		+ "\n"
        		+ "高さ：　" + dm.heightPixels);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
