package net.buildbox.pokeri.system_installreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

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

	public static class InstallReceiver extends BroadcastReceiver {
		// ブロードキャストの受信処理
		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "アプリケーション " + intent.getDataString() +
					" がインストールされました。", Toast.LENGTH_LONG).show();
		}
	}
}
