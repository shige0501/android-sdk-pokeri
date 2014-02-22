package net.buildbox.pokeri.ui_timepickerdialog;

import android.os.Bundle;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

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

	public static class TimePickerFragment extends DialogFragment
								implements TimePickerDialog.OnTimeSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// 時刻ピッカーダイアログを呼び出す（初期値に12:34を直接指定）
			return new TimePickerDialog(
					getActivity(),
					TimePickerDialog.THEME_HOLO_DARK,
					this,
					12, 34, true);
					
		}

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// 時刻ピッカーダイアログで設定された値をToastで表示
			Toast.makeText(getActivity(),
					"結果は" + hourOfDay + "時" + minute + "分です。",
					Toast.LENGTH_SHORT).show();
		}
	}

	public void showTimePickerDialog(View v) {
		// 時刻ピッカーダイアログの表示
		TimePickerFragment newFragment = new TimePickerFragment();
		newFragment.show(getSupportFragmentManager(), "showTimePickerDialog");
	}
}
