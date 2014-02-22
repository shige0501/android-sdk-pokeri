package net.buildbox.pokeri.ui_preferenceactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingPrefActivity extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// プリファレンス画面の設定
		addPreferencesFromResource(R.xml.setting_pref);
	}
}
