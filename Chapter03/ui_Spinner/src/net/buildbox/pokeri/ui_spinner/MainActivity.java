package net.buildbox.pokeri.ui_spinner;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] items = {"10代", "20代", "30代", "40代", "50代以上"};
		
		Spinner spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
		// アダプタにアイテムを追加
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_spinner_item,
				items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// アダプタの設定
		spinnerAge.setAdapter(adapter);
		// スピナーのタイトル設定
		spinnerAge.setPrompt("年齢の選択");
		// ポジションの指定
		spinnerAge.setSelection(3);
		
		spinnerAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Spinner spnAge = (Spinner) parent;
				String item = (String) spnAge.getItemAtPosition(position);
				
				Log.d(TAG, "position: " + item);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
