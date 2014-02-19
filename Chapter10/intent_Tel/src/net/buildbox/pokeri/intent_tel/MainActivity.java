package net.buildbox.pokeri.intent_tel;

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
        
        Button btn_call = (Button) findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 電話をかける
				// "android.permission.CALL_PHONE"のパーミッションが必要
				Uri uriTel = Uri.parse("tel:0123-456-789");
				Intent intent = new Intent(Intent.ACTION_CALL, uriTel);
				startActivity(intent);
			}
		});
        
        Button btn_dial = (Button) findViewById(R.id.btn_dial);
        btn_dial.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ダイアル画面を呼び出す
				Uri uriTel = Uri.parse("tel:0123-456-789");
				Intent intent = new Intent(Intent.ACTION_DIAL, uriTel);
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
