package net.buildbox.pokeri.intent_activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class IntentActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        
        Intent retIntent = new Intent();
        retIntent.putExtra("return_text", "テキストを返します。");
        
        // 戻り値の設定
        setResult(RESULT_OK, retIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
