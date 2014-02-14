package net.buildbox.pokeri.app_shareactionprovider;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューの読み込み
		getMenuInflater().inflate(R.menu.main, menu);
		
		// 共有アクションの作成
		MenuItem menuItem = menu.findItem(R.id.menu_share_action_provider);
		ShareActionProvider sap = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
		// 共有履歴の保存先の指定
		sap.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);

		// 共有するIntentの設定
	    Intent shareIntent = new Intent();
	    shareIntent.setAction(Intent.ACTION_SEND)
	    	.setType("text/plain")
	    	.putExtra(Intent.EXTRA_TEXT, "http://gihyo.co.jp/");
	    sap.setShareIntent(shareIntent);
	    
	    // アクション履歴表示の設定
	    MenuItem menuItemRecent = menu.findItem(R.id.menu_share_action_provider_recent);
	    ShareActionProvider sapRecent = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItemRecent);
	    sapRecent.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
	    // 共有するIntentの設定
	    sapRecent.setShareIntent(shareIntent);
		
		return true;
	}

}
