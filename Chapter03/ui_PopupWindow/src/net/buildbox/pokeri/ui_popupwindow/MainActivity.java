package net.buildbox.pokeri.ui_popupwindow;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

	private PopupWindow mPopup = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showPopupWindow(View v) {
		// ポップアップウィンドウ用のレイアウト読み込み
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View popupView = (View) inflater.inflate(R.layout.popup_layout, null);
		
		// ポップアップウィンドウの生成
		mPopup = new PopupWindow(this);
		// レイアウトパラメータの設定
		mPopup.setWindowLayoutMode(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		// レイアウトのViewとの紐付け
		mPopup.setContentView(popupView);
		
		// ポップアップウィンドウの表示
		Button btnPopup = (Button) findViewById(R.id.btnPopup);
		mPopup.showAsDropDown(btnPopup);
	}
	
	// ポップアップウィンドウ上のボタンクリック処理
	public void onPopupClick(View v) {
		mPopup.dismiss();
	}
}
