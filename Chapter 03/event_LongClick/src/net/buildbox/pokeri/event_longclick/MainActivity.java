package net.buildbox.pokeri.event_longclick;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 長押し処理
        Button btn_longClick = (Button) findViewById(R.id.btn_longClick);
        btn_longClick.setOnLongClickListener(new View.OnLongClickListener() {
			
			public boolean onLongClick(View v) {
				Toast.makeText(getApplicationContext(), "長押しイベント", Toast.LENGTH_SHORT).show();
				// trueを返すと、後続のOnClickイベントがコールバック処理されない
				return false;
			}
		});
        
        btn_longClick.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "クリック", Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
