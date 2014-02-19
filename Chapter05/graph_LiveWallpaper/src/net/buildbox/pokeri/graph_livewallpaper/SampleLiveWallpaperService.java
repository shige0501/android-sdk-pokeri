package net.buildbox.pokeri.graph_livewallpaper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class SampleLiveWallpaperService extends WallpaperService {

	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	public Engine onCreateEngine() {
		// Engineを継承したRenderEngineのオブジェクトを返す
		return new RenderEngine();
	}

	public class RenderEngine extends Engine {
		
		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
			
			// 画面の描画
			onDrawCanvas();
		}
		
		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			super.onSurfaceChanged(holder, format, width, height);
		}
		
		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
		}
		
		public void onDrawCanvas() {
			// Canvasの取得
			Canvas canvas = getSurfaceHolder().lockCanvas();
			if (canvas != null) {
				// 背景色を青に変更
				canvas.drawColor(Color.BLUE);
				
				// 四角形の描画
				Rect rect = new Rect(10, 10, 100, 150);
				Paint paint = new Paint();
				paint.setColor(Color.YELLOW);
				canvas.drawRect(rect, paint);
				
				// Canvasの解放
				getSurfaceHolder().unlockCanvasAndPost(canvas);
			}
		}
	}
}
