package net.buildbox.pokeri.event_touchevent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			Toast.makeText(getApplicationContext(), "タッチ：ダウン", Toast.LENGTH_SHORT).show();
			break;
		case MotionEvent.ACTION_UP:
			Toast.makeText(getApplicationContext(), "タッチ：アップ", Toast.LENGTH_SHORT).show();
		}
    	return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
