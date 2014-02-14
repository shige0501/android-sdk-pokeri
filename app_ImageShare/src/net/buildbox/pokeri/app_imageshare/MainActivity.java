package net.buildbox.pokeri.app_imageshare;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// URI形式での画像表示
		if (getIntent().getAction() == Intent.ACTION_SEND) {
			Uri imgUri = null;
			
			imgUri = Uri.parse(getIntent().getExtras().get(Intent.EXTRA_STREAM).toString());
			
			if (imgUri != null) {
				ImageView iv_uri = (ImageView) findViewById(R.id.iv_target);
				iv_uri.setImageURI(imgUri);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
