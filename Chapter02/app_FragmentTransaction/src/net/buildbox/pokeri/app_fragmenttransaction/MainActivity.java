package net.buildbox.pokeri.app_fragmenttransaction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnPlus = (Button) findViewById(R.id.btnPlus);
		btnPlus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// フラグメントの動的な追加
				Fragment targetFragment = new TargetFragment();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.add(R.id.fragment_target, targetFragment, "targetFragment");
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
