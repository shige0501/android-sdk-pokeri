package net.buildbox.pokeri.ui_overscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

public class OverScrollView extends ListView {
	private static final String TAG = "OverScrollView";
	
	public OverScrollView(Context context) {
		super(context);
		
		// オーバースクロールモードの設定
		setOverScrollMode(OVER_SCROLL_ALWAYS);
	}
	
	public OverScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// オーバースクロールモードの設定
		setOverScrollMode(OVER_SCROLL_ALWAYS);
	}
	
	// オーバースクロールとしてonOverScrolledを呼び出す条件を指定
	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
			int scrollY, int scrollRangeX, int scrollRangeY,
			int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		return super.overScrollBy(0, deltaY, 0, scrollY, 0,
				scrollRangeY, 0, 100, isTouchEvent);
	}
	
	// オーバースクロール時の処理
	@Override
	protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
			boolean clampedY) {
		// オーバースクロールの情報のデバッグ出力
		Log.d(TAG, "call onOverScrolled(): "
			+ "scrollX=" + scrollX
			+ ", scrollY=" + scrollY
			+ ", clampedX=" + clampedX
			+ ", clampedY=" + clampedY);
		super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
	}
}
