package net.buildbox.pokeri.device_number;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 端末の電話番号の取得
		TelephonyManager telManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		String phoneNumber = telManager.getLine1Number();
		
		TextView tv_phoneNumber = (TextView) findViewById(R.id.tv_phoneNumber);
		tv_phoneNumber.setText("端末の電話番号: " + phoneNumber);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
