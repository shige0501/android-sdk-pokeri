package net.buildbox.pokeri.ui_dragdrop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class DropView extends ImageView {

	public DropView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public boolean onDragEvent(DragEvent event) {
		switch (event.getAction()) {
		case DragEvent.ACTION_DROP:
			// ドロップ時にドロップされた座標の表示
			Toast.makeText(getContext(),
					"ドロップした座標: " + event.getX() + ", " + event.getY(),
					Toast.LENGTH_SHORT).show();
			invalidate();
			break;
		}
		
		return true;
	};
}
