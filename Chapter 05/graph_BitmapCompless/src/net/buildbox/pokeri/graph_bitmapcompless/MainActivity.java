package net.buildbox.pokeri.graph_bitmapcompless;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

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
		// アイコン画像を取得
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		
		try {
			// sdcardディレクトリを指定
			File dirSD = Environment.getExternalStorageDirectory();
			
			// 日付でファイル名を作成
			Date date = new Date();
			SimpleDateFormat fileName = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.JAPANESE);
			
			// 保存処理開始
			FileOutputStream fos = null;
			fos = new FileOutputStream(new File(dirSD, fileName.format(date) + ".jpg"));
			
			// jpegで保存
			bitmap.compress(CompressFormat.JPEG, 100, fos);
			
			fos.close();
			fos = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
