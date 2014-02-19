package net.buildbox.pokeri.media_videoview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.VideoView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        VideoView vv = (VideoView) findViewById(R.id.videoView);
        // 動画のパス指定
        vv.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.movie);
        // 再生開始
        vv.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
