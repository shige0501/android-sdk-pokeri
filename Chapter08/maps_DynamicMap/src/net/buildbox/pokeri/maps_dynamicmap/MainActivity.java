package net.buildbox.pokeri.maps_dynamicmap;

import com.google.android.gms.maps.SupportMapFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showGoogleMap(View v) {
		// GoogleMapの動的な追加
		FragmentManager fragmentManager = getSupportFragmentManager();
		SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentByTag("GoogleMap");
		if (fragment == null) {
		    // SupportMapFragmentのインスタンスを生成
		    fragment = SupportMapFragment.newInstance();
		    // フラグメントの追加
		    FragmentTransaction transaction = fragmentManager.beginTransaction();
		    transaction.add(R.id.layoutGoogleMap, fragment, "GoogleMap");
		    transaction.commit();
		}
	}
}
