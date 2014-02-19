package net.buildbox.pokeri.maps_tile;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;

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
		
		// マップを非表示に設定
		map.setMapType(GoogleMap.MAP_TYPE_NONE);
		
		// 技術評論社のロゴをタイル表示
		TileProvider tileProvider = new UrlTileProvider(146, 27) {
			@Override
			public URL getTileUrl(int x, int y, int zoom) {
				URL url = null;
				try {
					// 技術評論社のロゴをURL指定
					url = new URL("http://image.gihyo.co.jp/assets/templates/gihyojp2007/image/gihyo_logo.png");
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return url;
			}
		};
		
		// マップ上にオーバーレイ表示する
		map.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
