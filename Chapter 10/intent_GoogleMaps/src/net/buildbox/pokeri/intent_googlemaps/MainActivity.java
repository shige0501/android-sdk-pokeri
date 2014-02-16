package net.buildbox.pokeri.intent_googlemaps;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn_maps = (Button) findViewById(R.id.btn_maps);
        btn_maps.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Googleマップで東京スカイツリーを呼び出す
				// (Google Earthがインストールされていると、アプリの選択画面が表示されます。)
				Uri uri = Uri.parse("geo:35.710058,139.810718");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
