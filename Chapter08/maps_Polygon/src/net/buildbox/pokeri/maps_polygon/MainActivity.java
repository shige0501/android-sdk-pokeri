package net.buildbox.pokeri.maps_polygon;

import java.util.Arrays;
import java.util.List;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

import android.graphics.Color;
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
		
		// ポリゴンの描画
		drawPolygon(map);
	}

	private void drawPolygon(GoogleMap map) {
		// ポリゴン描画の設定
		PolygonOptions options = new PolygonOptions();
		// 描画座標の設定
		options.addAll(createRectangle(new LatLng(70, 100), 10, 10));
		// 抜き取る場所の設定
		options.addHole(createRectangle(new LatLng(75, 90), 3, 3));
		// 線の設定
		options.strokeColor(Color.BLACK);
		// 線の幅
		options.strokeWidth(4);
		// 描画処理
		map.addPolygon(options);
	}
	
	private List<LatLng> createRectangle(LatLng center, double width, double height) {
		List<LatLng> rectList = Arrays.asList(
				new LatLng(center.latitude - height, center.longitude - width),
				new LatLng(center.latitude - height, center.longitude + width),
				new LatLng(center.latitude + height, center.longitude + width),
				new LatLng(center.latitude + height, center.longitude - width),
				new LatLng(center.latitude - height, center.longitude - width));
		return rectList;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
