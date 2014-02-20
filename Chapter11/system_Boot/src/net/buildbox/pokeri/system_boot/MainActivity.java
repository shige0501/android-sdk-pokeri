package net.buildbox.pokeri.system_boot;

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
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public static class BootReceiver extends BroadcastReceiver {
		// ブロードキャストの受信処理
		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "端末起動をトリガーに表示しました。", Toast.LENGTH_LONG).show();
		}
	}
}
