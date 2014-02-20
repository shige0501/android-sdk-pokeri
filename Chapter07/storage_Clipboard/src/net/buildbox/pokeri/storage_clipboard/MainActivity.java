package net.buildbox.pokeri.storage_clipboard;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn_copy = (Button) findViewById(R.id.btn_copy);
        btn_copy.setOnClickListener(new View.OnClickListener() {
			@SuppressWarnings("deprecation")
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@Override
			public void onClick(View v) {
				EditText et_target = (EditText) findViewById(R.id.et_target);
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
					// Android 3.0(API Level: 11）以降
					// 設定するテキストを含んだClipDataのアイテムを生成
					ClipData.Item item = new ClipData.Item(et_target.getText());
					
					// MIMETYPEの設定
					String[] mimeType = new String[1];
					mimeType[0] = ClipDescription.MIMETYPE_TEXT_PLAIN;
					
					// ClipDataの生成
					ClipData clipData = new ClipData(new ClipDescription("text_plain", mimeType), item);
					
					// ClipDataをClipManagerに設定
					ClipboardManager clipMgr = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
					clipMgr.setPrimaryClip(clipData);
				} else {
					// Android 2.3(API Level: 10)以前
					android.text.ClipboardManager clipMgr =
							(android.text.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
					// テキストの設定
					clipMgr.setText(et_target.getText());
				}
			}
		});
        
        Button btn_toastClipboard = (Button) findViewById(R.id.btn_toastClipboard);
        btn_toastClipboard.setOnClickListener(new View.OnClickListener() {
			@SuppressWarnings("deprecation")
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@Override
			public void onClick(View v) {
				String toastText = "";
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
					// Android 3.0(API Level: 11)以降
					ClipboardManager clipMgr = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
					// ClipDataの取得
					ClipData clipData = clipMgr.getPrimaryClip();
					// アイテムの取得
					ClipData.Item item = clipData.getItemAt(0);
					// テキストの取得
					toastText = item.getText().toString();
				} else {
					// Android 2.3(API Level: 10)以前
					android.text.ClipboardManager clipMgr =
							(android.text.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
					// テキストの取得
					toastText = clipMgr.getText().toString();
				}
				Toast.makeText(getApplicationContext(), "Text: " + toastText, Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
