package net.buildbox.pokeri.intent_googlenavi;

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
        
        Button btn_navi = (Button) findViewById(R.id.btn_navi);
        btn_navi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Googleマップナビで広島駅までのルート案内を呼び出す
				// この呼び出し方法は公式には公表されていません。
				Uri uri = Uri.parse("google.navigation:q=広島駅");
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
