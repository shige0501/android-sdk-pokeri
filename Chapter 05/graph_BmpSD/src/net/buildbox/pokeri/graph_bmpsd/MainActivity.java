package net.buildbox.pokeri.graph_bmpsd;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // SDカード上の画像からBitmapオブジェクトを取得
        // このサンプルを試す場合は、プロジェクトのルートにある"beach.jpg"を事前にSDカードにコピーして下さい。
        Bitmap bmp = BitmapFactory.decodeFile("/sdcard/beach.jpg");
        
        ImageView iv_sdcard = (ImageView) findViewById(R.id.iv_sdcard);
        iv_sdcard.setImageBitmap(bmp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
