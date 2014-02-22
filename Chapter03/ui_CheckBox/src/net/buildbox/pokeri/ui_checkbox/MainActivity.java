package net.buildbox.pokeri.ui_checkbox;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// チェックボックスの状態変化通知
		CheckBox chkState = (CheckBox) findViewById(R.id.chkState);
		chkState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (true == isChecked) {
		            Toast.makeText(buttonView.getContext(), "チェック：ON", Toast.LENGTH_SHORT).show();
		        } else {
		            Toast.makeText(buttonView.getContext(), "チェック:OFF", Toast.LENGTH_SHORT).show();
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
