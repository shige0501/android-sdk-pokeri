package net.buildbox.pokeri.ui_toast;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnToast = (Button) findViewById(R.id.btnToast);
		btnToast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// トーストの表示
				Toast.makeText(getApplicationContext(),
						"ボタンがクリックされました",
						Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
