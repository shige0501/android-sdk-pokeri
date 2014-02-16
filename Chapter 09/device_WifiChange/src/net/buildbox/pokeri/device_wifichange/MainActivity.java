package net.buildbox.pokeri.device_wifichange;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        // Wi-Fiの有効状態の取得
        WifiManager wifiMgr = (WifiManager) getSystemService(WIFI_SERVICE);
        boolean bEnabled = wifiMgr.isWifiEnabled();
        
        // Wi-Fiの有効状態をトグルボタンに反映
        ToggleButton tbtn_wifiChanged = (ToggleButton) findViewById(R.id.tbtn_wifiChange);
        tbtn_wifiChanged.setChecked(bEnabled);
        
        // 有効状態の切り替え
        tbtn_wifiChanged.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        // Wi-Fiの有効状態の変更
		        WifiManager wifiMgr = (WifiManager) getSystemService(WIFI_SERVICE);
				wifiMgr.setWifiEnabled(isChecked);
			}
		});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
