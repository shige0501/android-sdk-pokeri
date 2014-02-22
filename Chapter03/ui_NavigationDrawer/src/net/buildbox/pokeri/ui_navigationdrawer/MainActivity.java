package net.buildbox.pokeri.ui_navigationdrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {
	private static final String TAG = "MainActivity";
	
	private ActionBarDrawerToggle mDrawerToggle = null;
	private DrawerLayout mDrawerLayout = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ナビゲーションドロワー用のトグルを用意
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this,
				mDrawerLayout, R.drawable.ic_drawer,
				R.string.drawer_open, R.string.drawer_close) {
			// ナビゲーションドロワーが開かれたときに通知
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				Log.i(TAG, "call: onDrawerOpened()");
			}
			
			// ナビゲーションドロワーが閉じられたときに通知
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				Log.i(TAG, "call: onDrawerClosed()");
			}
			
			// ナビゲーションドロワーがスライド中に通知
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				super.onDrawerSlide(drawerView, slideOffset);
				Log.i(TAG, "call: onDrawerSlide()");
			}
			
			// ナビゲーションドロワーの状態変更通知
			@Override
			public void onDrawerStateChanged(int newState) {
				super.onDrawerStateChanged(newState);
				Log.i(TAG, "call: onDrawerStateChanged()");
			}
		};
		
		// ナビゲーションドロワーのリスナー設定
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		// アプリケーションアイコンの制御を有効化
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// アクティビティとナビゲーションドロワーの状態を同期化
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// デバイスの状態変化をナビゲーションドロワーに通知
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		// android.id.homeのイベントを処理
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		if (item.getItemId() == R.id.action_drawer) {
			// ナビゲーションドロワーを開く
			mDrawerLayout.openDrawer(Gravity.LEFT);
		}
		
		return super.onOptionsItemSelected(item);
	}
}
