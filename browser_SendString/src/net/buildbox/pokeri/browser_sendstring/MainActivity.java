package net.buildbox.pokeri.browser_sendstring;

import android.os.Bundle;
import android.provider.Browser;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

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
	
	public void onClickEvent(View v) {
		// 暗黙的Intentで文字列の送信
		Browser.sendString(this, "文字列の送信サンプルです。");
	}

}
