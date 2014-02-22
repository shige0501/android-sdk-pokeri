package net.buildbox.pokeri.ui_datepickerdialog;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
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

	public static class DatePickerFragment extends DialogFragment
								implements DatePickerDialog.OnDateSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// 日付ピッカーダイアログを呼び出す（初期値に2013/07/01を直接指定）
			return new DatePickerDialog(
					getActivity(),
					DatePickerDialog.THEME_HOLO_DARK,
					this,
					2013, 6, 1);
		}

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// 日付ピッカーダイアログで設定された値をToastで表示
			Toast.makeText(getActivity(),
					"結果は" + year + "年" + (monthOfYear+1) + "月" + dayOfMonth + "日です。",
					Toast.LENGTH_SHORT).show();
		}
	}
	
	public void showDatePickerDialog(View v) {
		// 日付ピッカーダイアログの表示
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "showDatePickerDialog");
	}
}
