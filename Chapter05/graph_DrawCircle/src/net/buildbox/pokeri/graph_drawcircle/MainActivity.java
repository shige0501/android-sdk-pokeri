package net.buildbox.pokeri.graph_drawcircle;

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
			
			// 円を描画する
			canvas.drawCircle(100.0f, 100.0f, 50.0f, mPaint);
		}
    }
}
