package net.buildbox.pokeri.intent_settings;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void callSettings(View v) {
    	// 設定アプリの呼び出し
		Intent intent = new Intent();
		intent.setAction(android.provider.Settings.ACTION_SETTINGS);
		startActivity(intent);
    }
    
    public void callAccessibility(View v) {
		// 設定アプリ：ユーザー補助の画面の呼び出し
		Intent intent = new Intent();	
        intent.setAction(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
    }
    
    public void callAccount(View v) {
        // 設定アプリ：アカウントの追加の画面の呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_ADD_ACCOUNT);
        startActivity(intent);
    }
    
    public void callAirplaneMode(View v) {
        // 設定アプリ:機内モードの設定の呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(intent);
    }
    
    public void callApn(View v) {
        // 設定アプリ:APNの呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_APN_SETTINGS);
        startActivity(intent);
    }
    
    public void callApplicationDetail(View v) {
        // 設定アプリ:アプリの詳細画面の呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:net.buildbox.pokeri.intent_settings"));
        startActivity(intent);
    }
    
    public void callApplicationDevelopment(View v) {
        // 設定アプリ:開発者向けオプションの呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
        startActivity(intent);
    }
    
    public void callApplication(View v) {
        // 設定アプリ:アプリの呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(intent);
    }
    
    public void callBluetooth(View v) {
        // 設定アプリ:Bluetoothの呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(intent);
    }
    
    public void callDataRoaming(View v) {
        // 設定アプリ:モバイルネットワーク設定の呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
        startActivity(intent);
    }
    
    public void callDate(View v) {
        // 設定アプリ:日付と時刻の呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_DATE_SETTINGS);
        startActivity(intent);
    }
    
    public void callDeviceInfo(View v) {
        // 設定アプリ:端末の状態の呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_DEVICE_INFO_SETTINGS);
        startActivity(intent);
    }
    
    public void callDisplay(View v) {
        // 設定アプリ:ディスプレイの呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_DISPLAY_SETTINGS);
        startActivity(intent);
    }
    
    public void callInputMethod(View v) {
        // 設定アプリ:言語と入力の呼び出し
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS);
        startActivity(intent);
    }
    
     public void callStorage(View v) {
         // 設定アプリ:ストレージの設定の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
         startActivity(intent);
     }
     
     public void callLocale(View v) {
         // 設定アプリ:言語の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_LOCALE_SETTINGS);
         startActivity(intent);
     }
     
     public void callLocation(View v) {
         // 設定アプリ:位置情報サービスの呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
         startActivity(intent);
     }
     
     public void callAllApplication(View v) {
         // 設定アプリ:すべてのアプリ管理画面の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
         startActivity(intent);
     }
     
     public void callDownloadApplication(View v) {
         // 設定アプリ:ダウンロード済みのアプリ管理画面の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
         startActivity(intent);
     }
     
     public void callMemoryCard(View v) {
         // 設定アプリ:SDカードの設定画面の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_MEMORY_CARD_SETTINGS);
         startActivity(intent);
     }
     
     public void callNetwork(View v) {
         // 設定アプリ:利用可能なネットワークの呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
         startActivity(intent);
     }
     
     public void callNFC(View v) {
         // 設定アプリ:NFCの設定の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_NFC_SETTINGS);
         startActivity(intent);
     }
     
     public void callNFCSharing(View v) {
         // 設定アプリ:Androidビームの呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_NFCSHARING_SETTINGS);
         startActivity(intent);
     }
     
     public void callPrivacy(View v) {
         // 設定アプリ:個人データの設定の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_PRIVACY_SETTINGS);
         startActivity(intent);
     }
     
     public void callLaunch(View v) {
         // 設定アプリ:クイック起動の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_QUICK_LAUNCH_SETTINGS);
         startActivity(intent);
     }
     
     public void callSearch(View v) {
         // 設定アプリ:検索設定の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_SEARCH_SETTINGS);
         startActivity(intent);
     }
     
     public void callSecurity(View v) {
         // 設定アプリ:セキュリティの呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_SECURITY_SETTINGS);
         startActivity(intent);
     }
     
     public void callSound(View v) {
         // 設定アプリ:音の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_SOUND_SETTINGS);
         startActivity(intent);
     }
     
     public void callSync(View v) {
         // 設定アプリ:同期の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_SYNC_SETTINGS);
         startActivity(intent);
     }
     
     public void callUserDictionary(View v) {
         // 設定アプリ:ユーザー辞書の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_USER_DICTIONARY_SETTINGS);
         startActivity(intent);
     }
    
     public void callWifiIP(View v) {
         // 設定アプリ:IP設定の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_WIFI_IP_SETTINGS);
         startActivity(intent);
     }
     
     public void callWifi(View v) {
         // 設定アプリ:Wi-Fiの呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_WIFI_SETTINGS);
         startActivity(intent);
     }
     
     public void callWireless(View v) {
         // 設定アプリ:無線の設定の呼び出し
         Intent intent = new Intent();
         intent.setAction(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
         startActivity(intent);
     }
     
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
