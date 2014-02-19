package net.buildbox.pokeri.media_frameanimation;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView iv_pic = (ImageView) findViewById(R.id.iv_pic);
		// 背景の設定
		iv_pic.setBackgroundResource(R.drawable.pic_animation);
		
		// AnimationDrawableの取得
		AnimationDrawable anim = (AnimationDrawable) iv_pic.getBackground();
		// アニメーションの開始
		anim.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
