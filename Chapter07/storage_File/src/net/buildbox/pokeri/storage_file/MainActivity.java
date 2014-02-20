package net.buildbox.pokeri.storage_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	// ファイルからの読み込み
	public void onReadEvent(View v) {
		try {
			BufferedReader inBuf = null;
			FileInputStream file = openFileInput("pokeri.txt");
			inBuf = new BufferedReader(new InputStreamReader(file));
			
			EditText etWriteText = (EditText) findViewById(R.id.etWriteText);
			String temp = "";
			temp = inBuf.readLine();
			while (temp != null) {
				etWriteText.setText(etWriteText.getText().toString() + temp + "\n");
				
				temp = inBuf.readLine();
			}
			
			
			inBuf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ファイルへの書き込み
	public void onWriteEvent(View v) {
		try {
			EditText etWriteText = (EditText) findViewById(R.id.etWriteText);
			BufferedWriter outBuf = null;
			FileOutputStream fos = openFileOutput("pokeri.txt", Context.MODE_PRIVATE);
			outBuf = new BufferedWriter(new OutputStreamWriter(fos));
			outBuf.write(etWriteText.getText().toString());
			outBuf.flush();
			outBuf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
