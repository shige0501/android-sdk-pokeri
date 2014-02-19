package net.buildbox.pokeri.intent_activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReturnActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        
        // 戻り値の設定
        setResult(15);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
