package net.buildbox.pokeri.tts_textspeech;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {

	TextToSpeech mTts = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// TextToSpeechの初期化
		mTts = new TextToSpeech(this, this);
		
		Button btn_speech = (Button) findViewById(R.id.btn_speech);
		btn_speech.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 読み上げ中かどうかをチェックし、読み上げ中の場合は停止する
				if (mTts.isSpeaking()) {
					mTts.stop();
				}
				
				// テキストの読み上げ
				EditText et_speechText = (EditText) findViewById(R.id.et_speechText);
				mTts.speak(et_speechText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onInit(int status) {
		// TextToSpeechの状態チェック
		if (TextToSpeech.SUCCESS == status) {
			// 英語ロケールが使用可能かチェック
			if (mTts.isLanguageAvailable(Locale.ENGLISH) >= TextToSpeech.LANG_AVAILABLE) {
				// 読み上げ言語を英語に設定
				mTts.setLanguage(Locale.ENGLISH);
			}
		}
	}

}
