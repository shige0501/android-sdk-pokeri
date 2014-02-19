package net.buildbox.pokeri.graph_drawtext;

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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new GraphView(this));
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
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
			mPaint.setColor(Color.RED);		// 色の指定
			mPaint.setTextSize(64.0f);		// テキストサイズの指定
			
			// テキストを描画する
			canvas.drawText("テキストの描画", 100.0f, 100.0f, mPaint);
		}
    }

}
