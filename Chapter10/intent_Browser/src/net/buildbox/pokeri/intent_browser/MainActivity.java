package net.buildbox.pokeri.intent_browser;

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
        
        Button btn_browser = (Button) findViewById(R.id.btn_browser);
        btn_browser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 技術評論社のWebサイトを呼び出す
				Uri uri = Uri.parse("http://www.gihyo.co.jp/");
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
