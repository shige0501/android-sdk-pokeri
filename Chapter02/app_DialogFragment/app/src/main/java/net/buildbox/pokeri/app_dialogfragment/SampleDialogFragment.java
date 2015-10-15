package net.buildbox.pokeri.app_dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by shige on 10/15/15.
 */
public class SampleDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // アラートダイアログの構築
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("サンプルダイアログ")
                .setMessage("サンプルメッセージ")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return builder.create();
    }
}
