package net.buildbox.pokeri.device_battery;

import android.os.BatteryManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// バッテリーの状態変化を取得するレシーバの登録
		BatteryReceiver receiver = new BatteryReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(receiver, intentFilter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// バッテリーレシーバ
	private class BatteryReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			// バッテリーの変化のIntentをチェック
			if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
				int status = intent.getExtras().getInt(BatteryManager.EXTRA_STATUS);
				switch (status) {
				case BatteryManager.BATTERY_STATUS_FULL:	// 充電がフルの状態
					Toast.makeText(context, "フル充電状態", Toast.LENGTH_SHORT).show();
					break;
				case BatteryManager.BATTERY_STATUS_CHARGING:	// 充電中
					Toast.makeText(context, "充電中", Toast.LENGTH_SHORT).show();
					break;
				case BatteryManager.BATTERY_STATUS_DISCHARGING:	// 充電切断
					Toast.makeText(context, "充電切断", Toast.LENGTH_SHORT).show();
					break;
				case BatteryManager.BATTERY_STATUS_NOT_CHARGING:	// 放電中
					Toast.makeText(context, "放電中", Toast.LENGTH_SHORT).show();
					break;
				case BatteryManager.BATTERY_STATUS_UNKNOWN:		// 状態不明
					Toast.makeText(context, "充電状態が不明", Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}
	}
}
