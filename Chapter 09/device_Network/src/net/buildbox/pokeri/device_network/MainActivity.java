package net.buildbox.pokeri.device_network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String BASE_URL = "http://p.tl/api/api_simple.php";

	// 本サンプルではピクシブ株式会社が提供するp.tlでのURL短縮を行っています。
	// API_KEYはこちら（http://p.tl/api.php）から取得したキーを設定してください。
	private static final String API_KEY = "eca77a5ec2abc8cee50a37b474fcf4d62fada1fb";

	// URI要求パラメータ
	private static final String PARAM_KEY = "key";
	private static final String PARAM_URI = "url";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClickEvent(View v) {
		// 短縮要求するURIの取得
		EditText etUri = (EditText) findViewById(R.id.etURI);
		String srcUri = etUri.getText().toString();
		
		// AsyncTaskの開始
		new NetworkTask().execute(srcUri);
	}
	
	private class NetworkTask extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... params) {
			// 短縮URIの取得
			String dstUri = fetchShortURI(params[0]);
			
			return dstUri;
		}
		
		@Override
		protected void onCancelled() {
			super.onCancelled();
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			
			Toast.makeText(getApplicationContext(), "short url: " + result, Toast.LENGTH_SHORT).show();
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}
	}

	// 短縮URIの取得
	private String fetchShortURI(String srcUri) {
		String shortUri = "";
		String reqUri = "";
		
		// 要求するURIの生成
		Uri.Builder uriBuilder = new Uri.Builder();
		uriBuilder.path(BASE_URL);
		uriBuilder.appendQueryParameter(PARAM_KEY, API_KEY);
		uriBuilder.appendQueryParameter(PARAM_URI, srcUri);
		reqUri = Uri.decode(uriBuilder.build().toString());
		
		// HTTPの要求
		String strRet = "";
		HttpClient httpClient = new DefaultHttpClient();
		
		HttpGet reqHttp = new HttpGet(reqUri);
		HttpResponse resHttp = null;
		
		try {
			// GET要求の実行
			resHttp = httpClient.execute(reqHttp);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// データの取得
		int status = resHttp.getStatusLine().getStatusCode();
		if (HttpStatus.SC_OK == status) {
			try {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				resHttp.getEntity().writeTo(outputStream);
				strRet = outputStream.toString();
				
				shortUri = extractShortUri(strRet); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return shortUri;
	}
	
	// p.tlのJSONデータから短縮URLの取得
	private String extractShortUri(String jsonData) {
		String strRet = "";
		try {
			JSONObject jsonObj = new JSONObject(jsonData);
			String status    = jsonObj.getString("status");
			if (status.equals("ok")) {
				strRet = jsonObj.getString("short_url");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return strRet;
	}
}
