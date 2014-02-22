package net.buildbox.pokeri.ui_switch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// スイッチの状態変化を検知
		Switch sw = (Switch) findViewById(R.id.switchState);
		sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (isChecked) {
		        	// スイッチがONの状態
		            Toast.makeText(buttonView.getContext(), "On", Toast.LENGTH_SHORT).show();
		        } else {
		        	// スイッチがOFFの状態
		            Toast.makeText(buttonView.getContext(), "Off", Toast.LENGTH_SHORT).show();
		        }
		    }
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
