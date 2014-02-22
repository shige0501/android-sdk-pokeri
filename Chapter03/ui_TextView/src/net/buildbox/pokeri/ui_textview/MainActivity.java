package net.buildbox.pokeri.ui_textview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_replace) {
			// TextViewのテキストを変更する
			TextView tvPokeri = (TextView) findViewById(R.id.tvPokeri);
			tvPokeri.setText("こんにちは、ポケットリファレンス。");
			// テキストカラーを青に変更
			tvPokeri.setTextColor(Color.BLUE);
		}
		
		return true;
	}
}
