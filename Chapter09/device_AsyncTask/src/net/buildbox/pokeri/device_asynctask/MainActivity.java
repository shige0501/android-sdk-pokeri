package net.buildbox.pokeri.device_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
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

	public void onClickEvent(View v) {
		// プログレスダイアログの表示
		ProgressFragment newFragment = new ProgressFragment();
		newFragment.show(getSupportFragmentManager(), "onClickEvent");
	}

	// プログレスダイアログの表示
	public static class ProgressFragment extends DialogFragment {
		private ProgressDialog mDialog = null;

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// プログレスダイアログの生成
			mDialog = new ProgressDialog(getActivity());
			mDialog.setTitle("処理中..."); // タイトルの設定
			mDialog.setMessage("少々お待ちください..."); // メッセージの設定
			mDialog.setProgress(0);
			mDialog.setMax(300);
			mDialog.setCancelable(true); // キャンセルの許可
			mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); // プログレスの表示スタイル設定

			// AsyncTaskの開始
			new ProgressTask().execute("param");
			
			return mDialog;
		}

		private class ProgressTask extends AsyncTask<String, Integer, Long> {

			@Override
			protected Long doInBackground(String... params) {
        		while (mDialog.getProgress() < mDialog.getMax()) {
        			// 500ミリ秒の待ち処理
        			SystemClock.sleep(500);
        			
        			
        			publishProgress(mDialog.getProgress() + 5);
        		}
				return 0L;
			}
			
			@Override
			protected void onCancelled() {
				super.onCancelled();
				mDialog.dismiss();
			}
			
			@Override
			protected void onPostExecute(Long result) {
				super.onPostExecute(result);
				
				mDialog.dismiss();
			}
			
			@Override
			protected void onProgressUpdate(Integer... values) {
				super.onProgressUpdate(values);
				
				mDialog.setProgress(values[0]);
			}
		}
	}

}
