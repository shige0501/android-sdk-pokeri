package com.example.storage_preference;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

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

	// プリファレンスからの読み込み処理
	public void onReadEvent(View v) {
		// プリファレンスからの読み込み
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String strMessage = prefs.getString("key_message", "");
		
		EditText etMessage = (EditText) findViewById(R.id.etMessage);
		etMessage.setText(strMessage);
	}
		
	// プリファレンスへの書き込み処理
	public void onWriteEvent(View v) {
		EditText etMessage = (EditText) findViewById(R.id.etMessage);
		String strMessage = etMessage.getText().toString();
		
		// プリファレンスへの書き込み処理
		SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
		editor.putString("key_message", strMessage);
		editor.commit();
	}
}
