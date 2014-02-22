package net.buildbox.pokeri.ui_timepicker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TimePicker picker = (TimePicker) findViewById(R.id.timePicker);
		picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
		    @Override
		    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		        // 時刻が変更された時にToastを出力
		        Toast.makeText(
		                view.getContext(),
		                hourOfDay + ":" + minute + "です。",
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
