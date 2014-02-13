package net.buildbox.pokeri.app_fragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {
	// ログ出力用タグ
	private static final String TAG = "MainFragment";

	@Override
	public void onAttach(Activity activity) {
		Log.d(TAG, "call onAttach().");
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "call onCreate().");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "call onCreateView().");
		
		// フラグメントのインフレート
		return inflater.inflate(R.layout.fragment_main, container);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d(TAG, "call onActivityCreated().");
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		Log.d(TAG, "call onViewStateRestored().");
		super.onViewStateRestored(savedInstanceState);
	}
	
	@Override
	public void onStart() {
		Log.d(TAG, "call onStart().");
		super.onStart();
	}
	
	@Override
	public void onResume() {
		Log.d(TAG, "call onResume().");
		super.onResume();
	}
	
	@Override
	public void onPause() {
		Log.d(TAG, "call onPause().");
		super.onPause();
	}
	
	@Override
	public void onStop() {
		Log.d(TAG, "call onStop().");
		super.onStop();
	}
	
	@Override
	public void onDestroyView() {
		Log.d(TAG, "call onDestroyView().");
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		Log.d(TAG, "call onDestroy().");
		super.onDestroy();
	}
	
	@Override
	public void onDetach() {
		Log.d(TAG, "call onDetach().");
		super.onDetach();
	}
}
