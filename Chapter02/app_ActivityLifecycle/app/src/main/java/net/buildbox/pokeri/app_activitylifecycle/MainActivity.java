package net.buildbox.pokeri.app_activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    // Log出力用タグ
    private static final String TAG = "app_ActivityLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "call onCreate().");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "call onRestart().");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "call onStart().");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "call onResume().");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "call onPause().");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "call onStop().");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "call onDestroy().");
    }
}
