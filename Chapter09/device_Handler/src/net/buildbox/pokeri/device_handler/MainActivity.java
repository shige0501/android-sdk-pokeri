package net.buildbox.pokeri.device_handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// プログレスダイアログの表示
		ProgressFragment newFragment = new ProgressFragment();
		newFragment.show(getSupportFragmentManager(), "onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// プログレスダイアログの表示
	public static class ProgressFragment extends DialogFragment {
	    private ProgressDialog mDialog = null;
	    private static Handler mHandler = null;
		
		@Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        // プログレスダイアログの生成
	        mDialog = new ProgressDialog(getActivity());
	        mDialog.setTitle("処理中...");           // タイトルの設定
	        mDialog.setMessage("少々お待ちください..."); // メッセージの設定
	        mDialog.setProgress(0);
	        mDialog.setMax(300);
	        mDialog.setCancelable(true);             // キャンセルの許可
	        mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  // プログレスの表示スタイル設定
	        
	        // ハンドラ処理
	        mHandler = new Handler() {
	        	@Override
	        	public void handleMessage(Message msg) {
	        		mDialog.setProgress(mDialog.getProgress() + 5);
	        		
	        		if (mDialog.getProgress() < mDialog.getMax()) {
	        			// 500ミリ秒後にメッセージの送信
	        			sendEmptyMessageDelayed(0, 500);
	        		} else {
	        			// ダイアログの終了
	        			mDialog.dismiss();
	        		}
	        	}
	        };
	        mHandler.sendEmptyMessage(0);

	        return mDialog;
	    }       
	}

}
