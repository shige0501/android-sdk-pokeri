package net.buildbox.pokeri.media_tonegenerator;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private ToneGenerator mToneGenerator = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ToneGeneratorの生成
		mToneGenerator = new ToneGenerator(
				AudioManager.STREAM_SYSTEM,
				ToneGenerator.MAX_VOLUME);
		
		Button btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(mListener);
		Button btn2 = (Button) findViewById(R.id.btn2);
		btn2.setOnClickListener(mListener);
		Button btn3 = (Button) findViewById(R.id.btn3);
		btn3.setOnClickListener(mListener);
		Button btn4 = (Button) findViewById(R.id.btn4);
		btn4.setOnClickListener(mListener);
		Button btn5 = (Button) findViewById(R.id.btn5);
		btn5.setOnClickListener(mListener);
		Button btn6 = (Button) findViewById(R.id.btn6);
		btn6.setOnClickListener(mListener);
		Button btn7 = (Button) findViewById(R.id.btn7);
		btn7.setOnClickListener(mListener);
		Button btn8 = (Button) findViewById(R.id.btn8);
		btn8.setOnClickListener(mListener);
		Button btn9 = (Button) findViewById(R.id.btn9);
		btn9.setOnClickListener(mListener);
		Button btnA = (Button) findViewById(R.id.btnA);
		btnA.setOnClickListener(mListener);
		Button btn0 = (Button) findViewById(R.id.btn0);
		btn0.setOnClickListener(mListener);
		Button btnB = (Button) findViewById(R.id.btnB);
		btnB.setOnClickListener(mListener);
		
	}
	
	private View.OnClickListener mListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn1:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_1, 200);
				break;
			case R.id.btn2:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_2, 200);
				break;
			case R.id.btn3:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_3, 200);
				break;
			case R.id.btn4:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_4, 200);
				break;
			case R.id.btn5:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_5, 200);
				break;
			case R.id.btn6:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_6, 200);
				break;
			case R.id.btn7:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_7, 200);
				break;
			case R.id.btn8:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_8, 200);
				break;
			case R.id.btn9:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_9, 200);
				break;
			case R.id.btnA:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_A, 200);
				break;
			case R.id.btn0:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_0, 200);
				break;
			case R.id.btnB:
				mToneGenerator.startTone(ToneGenerator.TONE_DTMF_B, 200);
				break;
			}
			
		}
	};
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		// ToneGeneratorの解放
		mToneGenerator.release();
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
