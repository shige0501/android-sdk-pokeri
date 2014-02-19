package net.buildbox.pokeri.intent_googlestreetview;

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
        
        Button btn_sv = (Button) findViewById(R.id.btn_sv);
        btn_sv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 広島市内のストリートビューを呼び出す
				Uri uri = Uri.parse("google.streetview:cbll=34.384388, 132.453391");
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
