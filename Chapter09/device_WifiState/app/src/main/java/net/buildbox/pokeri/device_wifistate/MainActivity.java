package net.buildbox.pokeri.device_wifistate;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wi-Fiの有効状態取得
        WifiManager wifiMgr = (WifiManager) getSystemService(WIFI_SERVICE);
        boolean bEnabled = wifiMgr.isWifiEnabled();

        TextView tv_wifiEnabled = (TextView) findViewById(R.id.tv_wifiEnabled);
        tv_wifiEnabled.setText("Wi-Fiの有効状態: " + (bEnabled? "true" : "false") );

        // Wi-Fiの状態を取得
        int wifiState = wifiMgr.getWifiState();
        TextView tv_wifiState = (TextView) findViewById(R.id.tv_wifiState);
        switch (wifiState) {
            case WifiManager.WIFI_STATE_DISABLING:
                // 無効化中
                tv_wifiState.setText("Wi-Fiの状態： 無効化中");
                break;
            case WifiManager.WIFI_STATE_DISABLED:
                // 無効状態
                tv_wifiState.setText("Wi-Fiの状態： 無効");
                break;
            case WifiManager.WIFI_STATE_ENABLING:
                // 有効化中
                tv_wifiState.setText("Wi-Fiの状態: 有効化中");
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                // 有効状態
                tv_wifiState.setText("Wi-Fiの状態： 有効");
                break;
            case WifiManager.WIFI_STATE_UNKNOWN:
                // 不定
                tv_wifiState.setText("Wi-Fiの状態: 不明");
                break;
        }
    }
}
