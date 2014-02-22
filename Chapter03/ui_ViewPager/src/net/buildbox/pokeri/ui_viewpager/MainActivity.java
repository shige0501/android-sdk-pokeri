package net.buildbox.pokeri.ui_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	private MyFragmentPagerAdapter mPagerAdapter = null;
	private ViewPager mViewPager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// FragmentPagerAdapterの設定
		mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
		
		// ViewPagerの設定
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mViewPager.setAdapter(mPagerAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// ViewPager用のAdapterの設定
	// メモリ使用量が多い、Fragmentを大量に生成するような場合はFragmentPagerAdapterを検討すること
	public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		// 画面表示するFragmentを返す
		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new FirstFragment();
			case 1:
				return new SecondFragment();
			default:
				return new ThirdFragment();
			}
		}

		// 表示するFragment数を返す
		@Override
		public int getCount() {
			return 3;
		}
		
		// ページタイトルを返す
		@Override
		public CharSequence getPageTitle(int position) {
			return "Page: " + position;
		}
	}
}
