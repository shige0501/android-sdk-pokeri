package net.buildbox.pokeri.media_propertyanimation;

import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv_hello = (TextView) findViewById(R.id.tv_hello);
		tv_hello.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TextViewをフェードアウトするアニメーションの実施
				ObjectAnimator.ofFloat(v, "alpha", 0.0f).start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
