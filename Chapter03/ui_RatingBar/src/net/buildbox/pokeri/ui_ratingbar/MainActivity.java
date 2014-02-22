package net.buildbox.pokeri.ui_ratingbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// レーティングバーの状態変化通知
		RatingBar rbar_state = (RatingBar) findViewById(R.id.ratingState);
		rbar_state.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
		    @Override
		    public void onRatingChanged(RatingBar ratingBar, float rating,
		            boolean fromUser) {
		        Toast.makeText(getApplicationContext(),
		                "表示された星の数は " + rating + " です。",
		                Toast.LENGTH_SHORT).show();
		    }
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
