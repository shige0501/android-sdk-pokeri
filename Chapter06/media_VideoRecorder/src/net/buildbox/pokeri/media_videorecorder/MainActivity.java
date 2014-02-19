package net.buildbox.pokeri.media_videorecorder;

import java.io.IOException;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.CompoundButton;

public class MainActivity extends Activity {
	MediaRecorder mRecorder = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new PreviewView(this));
		
		mRecorder = new MediaRecorder();
		
		// ビデオの入力ソースの設定
		mRecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
		// 出力フォーマットの設定
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		// エンコーダの設定
		mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
		
		// 保存先の設定
		String path = Environment.getExternalStorageDirectory() + "/video_record.3gp";
		mRecorder.setOutputFile(path);
		
		// 録画のフレームレートの設定
		mRecorder.setVideoFrameRate(30);
		// サイズの設定
		mRecorder.setVideoSize(640, 480);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
	};
	
	@Override
	public void onPause() {
		
		super.onPause();
	};
	
	CompoundButton.OnCheckedChangeListener mListener = new CompoundButton.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if (isChecked) { // 録画開始

				try {
					mRecorder.prepare();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 録画開始
				mRecorder.start();
			} else {	// 録画停止
				if (mRecorder != null) {
					mRecorder.stop();
					mRecorder.reset();
				}
			}
		}
	};
	
	private class PreviewView extends SurfaceView
					implements SurfaceHolder.Callback {
		private SurfaceHolder mHolder = null;
		public PreviewView(Context context) {
			super(context);
			
			mHolder = getHolder();
			mHolder.addCallback(this);
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			if (mRecorder != null) {
				// プレビュー用の画面設定
				mRecorder.setPreviewDisplay(mHolder.getSurface());
				
				// 録画準備
				try {
					mRecorder.prepare();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 録画開始
				mRecorder.start();
			}
		}
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// 録画の終了
			mRecorder.stop();
			mRecorder.reset();
			mRecorder.release();
			mRecorder = null;
		}
	}
}
