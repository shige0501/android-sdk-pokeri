package net.buildbox.pokeri.device_addresstoposition;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Geocoder geocoder = new Geocoder(this, Locale.getDefault());
		List<Address> addressList;
		try {
			// 東京ディズニーランドの位置を取得
			addressList = geocoder.getFromLocationName("千葉県浦安市舞浜１−１", 1);
			
			// 取得した1件目の位置情報を取得
			Address addr = addressList.get(0);
			double lat = addr.getLatitude();	// 緯度
			double lng = addr.getLongitude();	// 経度
			
			// 位置情報をトーストで表示
			Toast.makeText(this, "位置情報： " + lat + ", " + lng, Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
