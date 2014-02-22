package net.buildbox.pokeri.ui_preferencefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingPrefFragment extends PreferenceFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// プリファレンス画面の設定
		addPreferencesFromResource(R.xml.setting_pref);
	}
}
