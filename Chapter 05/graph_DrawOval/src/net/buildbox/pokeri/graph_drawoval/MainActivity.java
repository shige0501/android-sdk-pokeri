package net.buildbox.pokeri.graph_drawoval;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
		RectF mRectf = new RectF(30.0f, 30.0f, 60.0f, 80.0f);
		@Override
		public void onDraw(Canvas canvas) {
			mPaint.setColor(Color.RED);		// 色の設定
			
			// 楕円を描画する
			canvas.drawOval(mRectf, mPaint);
		}
    }
}
