package net.buildbox.pokeri.ui_radiobutton;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RadioGroup grpColor = (RadioGroup) findViewById(R.id.grp_color);
		grpColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Layoutのrootビューの取得
				LinearLayout layout = 
					(LinearLayout) findViewById(R.id.layout_root);
				
				// 背景色の変更
				switch (checkedId) {
					case R.id.rbtn_white:
						layout.setBackgroundColor(Color.WHITE);
						break;
					case R.id.rbtn_blue:
						layout.setBackgroundColor(Color.BLUE);
						break;
					case R.id.rbtn_yellow:
						layout.setBackgroundColor(Color.YELLOW);
						break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
