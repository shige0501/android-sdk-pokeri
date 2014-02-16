package net.buildbox.pokeri.device_wifichange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class WifiChangeReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		
		if (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
			int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
			switch (wifiState) {
			case WifiManager.WIFI_STATE_DISABLING:
				Toast.makeText(context, "無効化中です。", Toast.LENGTH_SHORT).show();
				break;
			case WifiManager.WIFI_STATE_DISABLED:
				Toast.makeText(context, "無効です。", Toast.LENGTH_SHORT).show();
				break;
			case WifiManager.WIFI_STATE_ENABLING:
				Toast.makeText(context, "有効化中です。", Toast.LENGTH_SHORT).show();
				break;
			case WifiManager.WIFI_STATE_ENABLED:
				Toast.makeText(context, "有効です。", Toast.LENGTH_SHORT).show();
				break;
			case WifiManager.WIFI_STATE_UNKNOWN:
				Toast.makeText(context, "不明です。", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}
}
