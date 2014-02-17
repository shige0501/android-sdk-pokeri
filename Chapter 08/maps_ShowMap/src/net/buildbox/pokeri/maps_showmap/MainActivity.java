package net.buildbox.pokeri.maps_showmap;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.fragmentMap);

		// GoogleMapのインスタンス取得
		GoogleMap map = fragment.getMap();
		
		// GoogleMapを利用する上での初期化処理
		try {
			MapsInitializer.initialize(this);
		} catch (GooglePlayServicesNotAvailableException e) {
			e.printStackTrace();
		}
		
		// 表示位置（東京駅）の生成
		LatLng posTokyoStation = new LatLng(35.681382, 139.766084);
		
		// 東京駅を表示
		CameraPosition.Builder builder = new CameraPosition.Builder();
		builder.target(posTokyoStation);	// カメラの表示位置の指定
		builder.zoom(13.0f);	// カメラのズームレベルの指定
		builder.bearing(0);		// カメラの向きの指定
		builder.tilt(25.0f);	// カメラの傾きの指定
		map.moveCamera(CameraUpdateFactory.newCameraPosition(builder.build()));
		
		// ピンの設定
		MarkerOptions options = new MarkerOptions();
		options.position(posTokyoStation);
		options.title("東京駅");
		
		// ピンの追加
		map.addMarker(options);
		
		// ピン上の情報がクリックされた時のイベント処理
		map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast.makeText(getApplicationContext(), "東京駅がクリックされました。", Toast.LENGTH_SHORT).show();
			}
		});
		
		// マップ上のクリックイベント処理
		map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
		    @Override
		    public void onMapClick(LatLng point) {
		        Toast.makeText(getApplicationContext(),
		        		"クリックされた座標は " + point.latitude + ", " + point.longitude, Toast.LENGTH_SHORT).show();
		    }
		});
		
		// マップ上の長押しイベント処理
		map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
		    @Override
		    public void onMapLongClick(LatLng point) {
		    	Toast.makeText(getApplicationContext(),
		        		"長押しされた座標は " + point.latitude + ", " + point.longitude, Toast.LENGTH_SHORT).show();
		    }
		});
		
		// カメラの状態変化イベント処理
		map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
		    @Override
		    public void onCameraChange(CameraPosition position) {
		        LatLng point = position.target;
		        Toast.makeText(getApplicationContext(),
		        		"カメラの状態が変化した座標は " + point.latitude + ", " + point.longitude, Toast.LENGTH_SHORT).show();
		    }
		});

		map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
