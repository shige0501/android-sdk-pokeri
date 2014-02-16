package net.buildbox.pokeri.intent_gallery;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private static final int CODE_ACTION_PICK = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageButton ibtn_gallery = (ImageButton) findViewById(R.id.ibtn_gallery);
        ibtn_gallery.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_PICK);
				intent.setType("image/*");
				startActivityForResult(Intent.createChooser(intent, "画像選択"), CODE_ACTION_PICK);
			}
		});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == CODE_ACTION_PICK
    			&& resultCode == RESULT_OK) {
    		try {
    			// 選択された画像をビットマップ形式で取得
    			InputStream is = getContentResolver().openInputStream(data.getData());
    			Bitmap bmp = BitmapFactory.decodeStream(is);
    			is.close();
    			
    			// 選択された画像の表示
    			ImageView iv_selImage = (ImageView) findViewById(R.id.iv_selImage);
    			iv_selImage.setImageBitmap(bmp);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	super.onActivityResult(requestCode, resultCode, data);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
