package net.buildbox.pokeri.graph_surfaceview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SampleSurfaceView extends SurfaceView
		implements SurfaceHolder.Callback, Runnable {
	private SurfaceHolder mHolder = null;	// ホルダー
	private Thread mThread = null;			// 描画用スレッド
	
	public SampleSurfaceView(Context context) {
		super(context);
		
		BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		
		// SurfaceHolderを取得し、描画処理用のコールバックを登録する
		mHolder = getHolder();
		mHolder.addCallback(this);
	}

	@Override
	public void run() {
		while (mThread != null) {
			Canvas canvas = mHolder.lockCanvas();
			if (canvas != null) {
				// 背景色を青に変更
				canvas.drawColor(Color.BLUE);
				
				// 四角形の描画
				Rect rect = new Rect(10, 10, 50, 50);
				Paint paint = new Paint();
				paint.setColor(Color.YELLOW);
				canvas.drawRect(rect, paint);
				mHolder.unlockCanvasAndPost(canvas);
			}
		}
	}

	// SurfaceView生成時のコールバック処理
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// 描画用スレッドの実行開始
		mThread = new Thread(this);
		mThread.start();
	}
	
	// SurfaceView変更時のコールバック処理
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	// SurfaceView破棄時のコールバック処理
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		mThread = null;
	}
}
