package net.buildbox.pokeri.ui_webview;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends FragmentActivity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		
		setContentView(R.layout.activity_main);
		
		// JavaScriptの有効化
		WebView webView = (WebView) findViewById(R.id.webView);
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		// WebViewClientの設定
		webView.setWebViewClient(new WebViewClient(){
			// Webページ読み込み開始時
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);

				// プログレスアイコンの表示
				setProgressBarIndeterminateVisibility(true);
			}
			
			// Webページ読み込み完了時
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				
				// プログレスアイコンの非表示化
				setProgressBarIndeterminateVisibility(false);
			}
		});
		
		// ピンチ操作による拡大・縮小の有効化
		settings.setBuiltInZoomControls(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューの読み込み
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
        WebView webView = (WebView) findViewById(R.id.webView);

        switch (item.getItemId()) {
		case R.id.menu_loadUrl:
			// 指定したURLのサイト読み込み
			webView.loadUrl("http://www.gihyo.co.jp/");
			return true;
		case R.id.menu_loadAsset:
	        // assetsからのサイト読み込み
	        webView.loadUrl("file:///android_asset/hello.html");
	        return true;
		case R.id.menu_loadSD:
			// SDカードからのサイト読み込み
	        // 本サンプルを実行する際は、サンプルプロジェクトのルートに配置した
	        // "sd.html"をsdcard直下に配置してください。
	        webView.loadUrl("file:///sdcard/sd.html");
	        return true;
		case R.id.menu_loadData:
			// HTMLソースからの読み込み
	        String srcHtml = 
	                "<!DOCTYPE html><html><head>" +
	                "<meta charset='UTF-8'>" +
	                "<title>Android API ポケットリファレンス　サンプル</title>" +
	                "</head><body>" +
	                "HTMLソースの文字列から直接HTMLとしてWebViewに表示するサンプルです。" +
	                "</body></html>";
	        // Android4.1のエミュレータではloadDataメソッドを用いると文字化けしてしまうため、
	        // 以下のようにloadDataWithBaseURLメソッドを呼び出しています。
	        // webView.loadData(srcHtml, "text/html", "UTF-8");
	        webView.loadDataWithBaseURL(null, srcHtml, "text/html", "UTF-8", null);
	        return true;
	    case R.id.menu_back:
	        // 前のページに戻る
	        webView.goBack();
	        return true;
	    case R.id.menu_forward:
	        // 次のページに進む
	        webView.goForward();
	        return true;
	    case R.id.menu_2back:
	    	// ２ステップ前のページに戻る
	    	webView.goBackOrForward(-2);
	    	return true;
	    }

		return super.onMenuItemSelected(featureId, item);
	}

}
