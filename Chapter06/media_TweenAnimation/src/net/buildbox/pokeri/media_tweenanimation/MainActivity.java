package net.buildbox.pokeri.media_tweenanimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView iv_icon = (ImageView) findViewById(R.id.iv_icon);
		
		iv_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// アニメーションの設定
				Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.sample);
				// アニメーション後の状態を保持
				animation.setFillAfter(true);
				// アニメーションの開始
				v.startAnimation(animation);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
