package net.buildbox.pokeri.intent_googleplay;

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
        
        Button btn_app = (Button) findViewById(R.id.btn_app);
        btn_app.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 『ゆうちょ金利 BETA』のGoogle Playアプリページを呼び出す
				Uri uri = Uri.parse("market://details?id=net.buildbox.app.StepMoney");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});
        
        Button btn_developer = (Button) findViewById(R.id.btn_developer);
        btn_developer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// パッケージ名でアプリを検索する
				Uri uri = Uri.parse("market://search?q=net.buildbox.app");
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
