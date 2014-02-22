package net.buildbox.pokeri.ui_numberpicker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
		numberPicker.setMaxValue(50);
		numberPicker.setMinValue(10);
		
		numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
		    @Override
		    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		        Toast.makeText(getApplicationContext(), 
		        		"前の値..." + oldVal + "  新しい値..." + newVal,
		        		Toast.LENGTH_SHORT).show();
		    }
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
