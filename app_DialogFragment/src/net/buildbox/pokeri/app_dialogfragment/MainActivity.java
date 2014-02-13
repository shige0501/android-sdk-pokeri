package net.buildbox.pokeri.app_dialogfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnShowDialog = (Button) findViewById(R.id.btnShowDialog);
		btnShowDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SampleDialogFragment dlgFragment = new SampleDialogFragment();
				dlgFragment.show(getSupportFragmentManager(), "sample_dialog_fragment");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
