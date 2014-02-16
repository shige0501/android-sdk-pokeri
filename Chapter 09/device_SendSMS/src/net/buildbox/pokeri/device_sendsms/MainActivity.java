package net.buildbox.pokeri.device_sendsms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
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
		SmsManager smsManager = SmsManager.getDefault();
		// 送信先の電話番号を設定する
		String destinationAddress = "090XXXXXXXX";
		// 送信するテキストを設定する
		String text = "Hello, Android SDKポケットリファレンス！";
		// 送信する
		smsManager.sendTextMessage(destinationAddress, null, text, null, null);
	}
}
