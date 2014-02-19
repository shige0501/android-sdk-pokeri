package net.buildbox.pokeri.intent_activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int CODE_SUB    = 1;
	private static final int CODE_INTENT = 2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn_activity = (Button) findViewById(R.id.btn_activity);
        btn_activity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 別Activityの呼び出し
				Intent intent = new Intent(getApplicationContext(), SubActivity.class);
				startActivity(intent);
			}
		});
        
        Button btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 値を返すActivityの呼び出し
				Intent intent = new Intent(getApplicationContext(), ReturnActivity.class);
				startActivityForResult(intent, CODE_SUB);
			}
		});
        
        
        Button btn_intent = (Button) findViewById(R.id.btn_intent);
        btn_intent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Intentを返すActivityの呼び出し
				Intent intent = new Intent(getApplicationContext(), IntentActivity.class);
				startActivityForResult(intent, CODE_INTENT);
			}
		});
    }

    // 呼び出し先のActivityからの結果のコールバック処理
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == CODE_SUB) {
    		Toast.makeText(this, "戻り値: " + resultCode, Toast.LENGTH_SHORT).show();
    	} else if (requestCode == CODE_INTENT) {
    		Toast.makeText(
    				this,
    				"戻りテキスト: " + data.getStringExtra("return_text"),
    				Toast.LENGTH_SHORT).show();
    	}
    	super.onActivityResult(requestCode, resultCode, data);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
