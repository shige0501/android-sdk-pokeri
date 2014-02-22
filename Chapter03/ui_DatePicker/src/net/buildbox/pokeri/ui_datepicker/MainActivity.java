package net.buildbox.pokeri.ui_datepicker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    // 2013/07/01でDatePickerを初期化し、変更時のイベントを受け取るリスナーの設定
	    DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
	    datePicker.init(2013, 6, 1, mListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	DatePicker.OnDateChangedListener mListener = new DatePicker.OnDateChangedListener() {
	    @Override
	    public void onDateChanged(DatePicker view, int year, int monthOfYear,
	            int dayOfMonth) {
	        // 日付が変更された時にToastを出力
	        Toast.makeText(
	                view.getContext(),
	                year + "/" + (monthOfYear + 1) + "/" + dayOfMonth + "です。",
	                Toast.LENGTH_SHORT).show();
	    }
	};

}
