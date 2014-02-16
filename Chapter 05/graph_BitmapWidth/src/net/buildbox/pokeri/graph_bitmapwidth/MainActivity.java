package net.buildbox.pokeri.graph_bitmapwidth;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ビットマップの幅、高さの取得
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		
		// 幅、高さの表示設定
		TextView tvWidth = (TextView) findViewById(R.id.tvWidth);
		tvWidth.setText("幅: " + width);
		TextView tvHeight = (TextView) findViewById(R.id.tvHeight);
		tvHeight.setText("高さ： " + height);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
