package net.buildbox.pokeri.device_positiontoaddress;

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
		
		Geocoder geocoder = new Geocoder(this, Locale.JAPAN);	
		// 東京の座標を設定して住所を取得する
		List<Address> addressList = null;
		try {
			addressList = geocoder.getFromLocation(35.689488, 139.691706, 1);
			
			// 住所の取得に成功したかチェック
			if (!addressList.isEmpty()) {
				Address addr = addressList.get(0);
				String strAddress = "", buf = "";
				for (int i = 0; (buf = addr.getAddressLine(i)) != null; i++) {
					strAddress += buf + "\n";
				}
				
				// 取得した住所をトーストで表示
				Toast.makeText(this, "取得した住所： " + strAddress, Toast.LENGTH_SHORT).show();
			}
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
