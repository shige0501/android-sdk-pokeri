package net.buildbox.pokeri.graph_bmprotate;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 画像リソースの読み込み
        AssetManager assetMgr = getAssets();
        try {
        	// assetsから取得した画像からBitmapオブジェクトを取得
        	InputStream is = assetMgr.open("balloons.jpg");
        	BufferedInputStream buf = new BufferedInputStream(is);
        	Bitmap bmp = BitmapFactory.decodeStream(buf);

        	// ビットマップの回転を設定
        	Matrix matrix = new Matrix();
        	matrix.postRotate(45.0f);
        	
        	Bitmap rotateBmp = Bitmap.createBitmap(bmp, 0, 0, 
        			bmp.getWidth(), bmp.getHeight(), matrix, true);
        	
        	// 画像をImageViewで表示
        	ImageView iv_rotate = (ImageView) findViewById(R.id.iv_rotate);
            iv_rotate.setImageBitmap(rotateBmp);
            
            // ストリームのクローズ
            buf.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
