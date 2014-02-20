package net.buildbox.pokeri.system_applist;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// インストール済みのアプリケーション一覧の取得
		ArrayList<String> appList = new ArrayList<String>();
		PackageManager packageMgr = getPackageManager();
		List<ApplicationInfo> applicationInfo = packageMgr.getInstalledApplications(PackageManager.GET_META_DATA);
		for (ApplicationInfo info : applicationInfo) {
			appList.add(packageMgr.getApplicationLabel(info).toString());
		}
		
		// リスト表示
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, appList);
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
