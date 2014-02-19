package net.buildbox.pokeri.graph_drawline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphView(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public class GraphView extends View {

		public GraphView(Context context) {
			super(context);
		}
    	
		// ペイントの生成
		Paint mPaint = new Paint(); 
		
		@Override
		public void onDraw(Canvas canvas) {
			mPaint.setColor(Color.RED);		// 色の設定
			mPaint.setStrokeWidth(16.0f);	// 先の太さ
			
			// 線を描画する
			canvas.drawLine(10.0f, 10.0f, 250.0f, 10.0f, mPaint);
			
			// 連続で線を描画する
			mPaint.setColor(Color.BLUE);
			float[] points = {
					10.0f, 30.0f,	// 1本目：始点
					160.0f, 120.0f,	// 1本目：終点
					160.0f, 120.0f,	// 2本目：始点
					200.0f, 60.0f	// 2本目：終点
			};
			canvas.drawLines(points, mPaint);
		}
    }
}
