package net.buildbox.pokeri.intent_contactlist;

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
        
        Button btn_contactList = (Button) findViewById(R.id.btn_contactList);
        btn_contactList.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// コンタクトリストの呼び出し（ID指定）
				Intent contactIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/10"));
				startActivity(contactIntent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
