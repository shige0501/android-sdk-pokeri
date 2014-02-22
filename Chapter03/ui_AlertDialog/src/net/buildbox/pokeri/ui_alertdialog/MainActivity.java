package net.buildbox.pokeri.ui_alertdialog;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
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

	public static class AlertDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// アラートダイアログの生成
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle("test")
				.setMessage("アラートダイアログです。\nAndroid SDKポケリ")
			    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			    	@Override
	    			public void onClick(DialogInterface dialog, int which) {
			    		// OKがクリックされた時の処理
		    			Toast.makeText(getActivity(), "OKクリック", Toast.LENGTH_SHORT).show();
		    		}
		    	})
			    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			        @Override
			        public void onClick(DialogInterface dialog, int which) {
			        	// Cancelがクリックされた時の処理
			        	Toast.makeText(getActivity(), "Cancelクリック", Toast.LENGTH_SHORT).show();
			        }
			    })
			    .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
			        @Override
			        public void onClick(DialogInterface dialog, int which) {
			            // Newtralがクリックされた時の処理
			        	Toast.makeText(getActivity(), "Neutralクリック", Toast.LENGTH_SHORT).show();
			        }
			    });

			return builder.create();
		}
	}

	public void showAlertDialog(View v) {
		// アラートダイアログの表示
		DialogFragment newFragment = new AlertDialogFragment();
		newFragment.show(getSupportFragmentManager(), "showAlertDialog");
	}
}
