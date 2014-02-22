package net.buildbox.pokeri.ui_calendarview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CalendarView calView = (CalendarView) findViewById(R.id.calendarView);
		calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
		    @Override
		    public void onSelectedDayChange(CalendarView view, int year, int month,
		            int dayOfMonth) {
		        Toast.makeText(
		                view.getContext(),
		                "選択されたのは" + year + "/" + (month + 1) + "/" + dayOfMonth +"です。",
		                Toast.LENGTH_SHORT)
		            .show();
		    }
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
