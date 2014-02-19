package net.buildbox.pokeri.maps_polyline;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.fragmentMap);
		
		GoogleMap map = fragment.getMap();
		
		// 線の描画設定
		PolylineOptions options = new PolylineOptions();
		options.add(new LatLng(35.689488, 139.691706));	// 東京
		options.add(new LatLng(-14.235004, -51.92528));	// ブラジル
		options.color(Color.BLUE);	// 線の色
		options.width(5);			// 線の太さ
		options.geodesic(true);		// 測地線形式の表示
		
		// 線の描画
		map.addPolyline(options);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
