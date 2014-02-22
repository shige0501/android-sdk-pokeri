package net.buildbox.pokeri.ui_progressdialog;

import android.os.Bundle;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

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
	
	// プログレスダイアログの表示
	public static class ProgressFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// プログレスダイアログの生成
			ProgressDialog dialog = new ProgressDialog(getActivity());
			dialog.setTitle("処理中...");			// タイトルの設定
			dialog.setMessage("少々お待ちください...");	// メッセージの設定
			dialog.setCancelable(true);				// キャンセルの許可
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);	// プログレスの表示スタイル設定
			
			return dialog;
		}		
	}

	public void showProgressDialog(View v) {
		// プログレスダイアログの表示
		ProgressFragment newFragment = new ProgressFragment();
		newFragment.show(getSupportFragmentManager(), "showProgressDialog");
	}
}
