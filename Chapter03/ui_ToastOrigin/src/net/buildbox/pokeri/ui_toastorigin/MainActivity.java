package net.buildbox.pokeri.ui_toastorigin;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnToast = (Button) findViewById(R.id.btnToastOrigin);
		btnToast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// カスタムビューの読み込み
				LayoutInflater layoutInflater = getLayoutInflater();
				View customView = layoutInflater.inflate(
						R.layout.toast_origin, (ViewGroup) findViewById(R.id.root_ToastOrigin));
				
				// トーストの生成
				Toast orgToast = Toast.makeText(v.getContext(), "", Toast.LENGTH_LONG);
				// トーストの表示位置の設定
				orgToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				// カスタムビューの設定
				orgToast.setView(customView);
				// トーストの表示
				orgToast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
