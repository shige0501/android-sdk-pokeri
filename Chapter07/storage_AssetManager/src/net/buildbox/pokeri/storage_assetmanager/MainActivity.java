package net.buildbox.pokeri.storage_assetmanager;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // AssetManagerの取得
        AssetManager assetMgr = getAssets();
        try {
        	// 『data』ディレクトリ内のファイル一覧を取得
			String [] fileList = assetMgr.list("data");
			TextView tv_list1 = (TextView) findViewById(R.id.tv_fileList1);
			showList(tv_list1, fileList);
			
			// 『data/gif』ディレクトリ内のファイル一覧取得
			fileList = assetMgr.list("data/gif");
			TextView tv_list2 = (TextView) findViewById(R.id.tv_fileList2);
			showList(tv_list2, fileList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    // ファイルの一覧を展開
    public void showList(TextView tv, String[] list) {
		for (String filePath : list) {
			tv.setText(
					tv.getText() + 
					filePath + "\n");
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
