package net.buildbox.pokeri.maps_location;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.SupportMapFragment;

import android.location.Location;
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
		
		// 現在位置の表示を有効化
		map.setMyLocationEnabled(true);
		
		// 現在位置を設定
		map.setLocationSource(new LocalLocationSource());
	}
	
	private class LocalLocationSource implements LocationSource {
		@Override
		public void activate(OnLocationChangedListener listener) {
			// 位置情報の設定（ディズニーランド）
			Location loc = new Location("LocalLocation");
			loc.setLatitude(35.632547);		// 緯度
			loc.setLongitude(139.88133);	// 経度
			loc.setAccuracy(100);			// 精度
			listener.onLocationChanged(loc);
		}

		@Override
		public void deactivate() {
		}	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
