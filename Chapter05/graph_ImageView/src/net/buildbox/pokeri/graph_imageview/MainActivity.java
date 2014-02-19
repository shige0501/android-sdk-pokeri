package net.buildbox.pokeri.graph_imageview;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn_resource = (Button) findViewById(R.id.btn_resource);
        btn_resource.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
		        // 画像リソースの読み込み
		        ImageView iv_resource = (ImageView) findViewById(R.id.iv_target);
		        iv_resource.setImageResource(R.drawable.photo1);
			}
		});
        
        Button btn_bitmap = (Button) findViewById(R.id.btn_bitmap);
        btn_bitmap.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ビットマップ形式で読み込み
				Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.photo2);
				ImageView iv_bitmap = (ImageView) findViewById(R.id.iv_target);
				iv_bitmap.setImageBitmap(bmp);
			}
		});
        
        Button btn_drawable = (Button) findViewById(R.id.btn_drawable);
        btn_drawable.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Drawable形式で読み込み
				BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.photo3);
				drawable.setAlpha(50);
				ImageView iv_drawable = (ImageView) findViewById(R.id.iv_target);
				iv_drawable.setImageDrawable(drawable);
			}
		});
        
        // URI形式での画像表示
        if (getIntent().getAction() == Intent.ACTION_SEND) {
        	Uri imgUri = null;
        	try {
        		imgUri = Uri.parse(
        				getIntent().getExtras().get("android.intent.extra.STREAM").toString());
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        	
        	if (imgUri != null) {
        		ImageView iv_uri = (ImageView) findViewById(R.id.iv_target);
				iv_uri.setImageURI(imgUri);
        	}
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
