package net.buildbox.pokeri.media_mediascannerconnection;

import java.io.File;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final String TAG = "media_MediaScannerConnection";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// SDカードにファイルを作成
		String fileName = "pokeri_test.jpg";
		String mimeType = "image/jpeg";
		File file = new File(
				Environment.getExternalStorageDirectory(),
				fileName);
		
		// MediaScannerConnectionでスキャン
		MediaScannerConnection.scanFile(
				this,
				new String[]{ file.getPath()},
				new String[]{ mimeType },
				mListener);
	}
	
	// スキャンが完了したときのコールバック処理
	MediaScannerConnection.OnScanCompletedListener mListener = new MediaScannerConnection.OnScanCompletedListener() {
		@Override
		public void onScanCompleted(String path, Uri uri) {
			Log.d(TAG, "path = " + path);
			Log.d(TAG, "uri = " + uri);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
