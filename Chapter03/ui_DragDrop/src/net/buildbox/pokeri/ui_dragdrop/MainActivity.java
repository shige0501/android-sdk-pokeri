package net.buildbox.pokeri.ui_dragdrop;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity 
		implements View.OnTouchListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// タッチリスナーの登録
		DragView iv_drag = (DragView) findViewById(R.id.iv_drag);
		iv_drag.setOnTouchListener(this);
		
		
		ImageView iv_drop = (ImageView) findViewById(R.id.iv_drop);
		iv_drop.setOnDragListener(new View.OnDragListener() {
			@Override
			public boolean onDrag(View v, DragEvent event) {
				if (event.getAction() == DragEvent.ACTION_DROP) {
					ClipData clipData = event.getClipData();
					for (int i = 0; i < clipData.getItemCount(); i++) {
						// ドラッグ開始時に渡したClipDataのテキストを表示
						ClipData.Item item = clipData.getItemAt(i);
						Toast.makeText(getApplicationContext(),
								item.coerceToText(getApplicationContext()),
								Toast.LENGTH_SHORT).show();
					}
				}
				
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			// ドラッグ処理の開始
			ClipData clipData = ClipData.newPlainText("label", "ドロップしました!");
			v.startDrag(clipData, new DragShadowBuilder(v), null, 0);
			return true;
		}
		return false;
	}
}
