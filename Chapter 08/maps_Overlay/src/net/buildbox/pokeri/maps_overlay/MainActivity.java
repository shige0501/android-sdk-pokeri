package net.buildbox.pokeri.maps_overlay;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
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
		
		// 東京駅の表示を指定
		LatLng location = new LatLng(35.681382, 139.766084);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 11));
		
		// 貼り付ける画像の生成
		BitmapDescriptor descriptor = BitmapDescriptorFactory.fromResource(android.R.drawable.sym_def_app_icon);
		
		// オーバーレイの設定
		GroundOverlayOptions options = new GroundOverlayOptions();
		options.image(descriptor);
		options.anchor(0, 1);
		options.position(location, 5000f, 4000f);
		GroundOverlay overlay = map.addGroundOverlay(options);
		overlay.setTransparency(0.4f);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
