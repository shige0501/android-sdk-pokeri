package net.buildbox.pokeri.device_callstate;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		// 電話情報の取得開始
		TelephonyManager telManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		telManager.listen(mPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
	}

	@Override
	protected void onPause() {
		// 電話情報の取得停止
		TelephonyManager telManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		telManager.listen(mPhoneStateListener, PhoneStateListener.LISTEN_NONE);
		
		super.onPause();
	}
	
	PhoneStateListener mPhoneStateListener = new PhoneStateListener() {
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_RINGING:	// 電話着信
				Toast.makeText(getApplicationContext(),
						incomingNumber + "から着信しました",
						Toast.LENGTH_SHORT).show();
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:	// 通話開始
				Toast.makeText(getApplicationContext(),
						incomingNumber + "と通話を開始しました",
						Toast.LENGTH_SHORT).show();
				break;
			case TelephonyManager.CALL_STATE_IDLE:		// 通話終了
				Toast.makeText(getApplicationContext(),
						incomingNumber + "との通話を終了しました",
						Toast.LENGTH_SHORT).show();
				break;
			}
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
