package net.buildbox.pokeri.device_back;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // アプリケーションの終了処理
        Button btn_quit = (Button) findViewById(R.id.btn_quit);
        btn_quit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
    }

    // BACKキーの無効化
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
    	if (KeyEvent.ACTION_DOWN == event.getAction()) {
    		switch (event.getKeyCode()) {
    		case KeyEvent.KEYCODE_BACK:
    			// falseで次のイベント処理に流れ、
    			// trueのときここで処理された後に終了する
    			return true;
    		}
    	}
		return super.dispatchKeyEvent(event);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
