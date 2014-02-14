package com.example.device_bluetoothenable;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int REQUEST_ENABLE_BLUETOOTH = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		boolean bEnable = bluetoothAdapter.isEnabled();
		if (bEnable) {
			// Bluetoothが有効だった場合の処理
			Toast.makeText(this, "Bluetoothは有効です。", Toast.LENGTH_SHORT).show();
		} else {
			// Bluetoothが無効だった場合、Bluetoothの有効化を行うダイアログを表示
			Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(bluetoothIntent, REQUEST_ENABLE_BLUETOOTH);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == REQUEST_ENABLE_BLUETOOTH) {
			if (resultCode == Activity.RESULT_OK) {
				Toast.makeText(this, "Bluetoothを有効化しました。", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Bluetoothを有効化しませんでした。", Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
