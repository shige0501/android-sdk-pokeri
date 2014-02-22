package net.buildbox.pokeri.ui_viewpager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FirstFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 用意したレイアウトのインフレート
		return inflater.inflate(R.layout.fragment_first, null);
	}
}
