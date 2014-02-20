package net.buildbox.pokeri.sensor_accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity 
				implements SensorEventListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv_accelerometer = (TextView) findViewById(R.id.tv_accelerometer);
		
		// SensorManagerの取得
		SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		
		// 端末が加速度センサに対応しているか確認
		if (sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0) {
			// 加速度センサに未対応
			tv_accelerometer.setText("加速度センサに未対応です");
		} else {
			// 端末の加速度センサの取得
			Sensor accelerometer = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			
			// 加速度センサのイベントを受け取るリスナーの登録
			if (!sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI)) {
				// 加速度センサのリスナー登録に失敗
				tv_accelerometer.setText("リスナーの登録に失敗しました");
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// センサの精度が変更された時に呼び出されるコールバック
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}

	// センサの状態が変化した時に呼び出されるコールバック
	@Override
	public void onSensorChanged(SensorEvent event) {
		// 加速度の情報を表示する
		TextView tv_accelerometer = (TextView) findViewById(R.id.tv_accelerometer);
		tv_accelerometer.setText(
				"X: " + event.values[0] +
				", Y: " + event.values[1] +
				", Z: " + event.values[2]);
	}
}
