package net.buildbox.pokeri.app_fragmenttransaction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shige on 10/12/15.
 */
public class TargetFragment extends Fragment {
    private static int mCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 用意したレイアウトのインフレート
        View view = inflater.inflate(R.layout.fragment_target, null);

        // フラグメントを呼び出した回数をカウント
        TextView tvCount = (TextView) view.findViewById(R.id.tvCount);
        tvCount.setText("count: " + ++mCount);

        return view;
    }
}
