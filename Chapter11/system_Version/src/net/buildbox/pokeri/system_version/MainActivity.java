package net.buildbox.pokeri.system_version;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int versionCode = 0;
		String versionName = "";
		
		// バージョン情報の取得
		PackageManager packageMgr = getPackageManager();
		try {
			PackageInfo packageInfo = packageMgr.getPackageInfo(getPackageName(),
					PackageManager.GET_ACTIVITIES);
			versionCode = packageInfo.versionCode;	//　AndroidManifest.xmlで定義したバージョンコード
			versionName = packageInfo.versionName;	// AndroidManifest.xmlで定義したバージョン名
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		// バージョン情報の表示
		TextView tv_Version = new TextView(this);
		tv_Version.setText("versionCode = " + versionCode + "\n" +
				"versionName = " + versionName);
		setContentView(tv_Version);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
