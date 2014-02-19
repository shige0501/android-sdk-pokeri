package net.buildbox.pokeri.app_textshare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 受け取ったテキストをToastで表示する
		Intent intent = getIntent();
		if (intent != null) {
			if (intent.getAction().equals(Intent.ACTION_SEND)) {
				String receiveText = intent.getExtras().getString(Intent.EXTRA_TEXT);
				Toast.makeText(this, "受け取ったテキスト: " + receiveText, Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
