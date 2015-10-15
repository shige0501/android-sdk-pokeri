package net.buildbox.pokeri.app_dialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowDialog = (Button) findViewById(R.id.btnShowDialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SampleDialogFragment dlgFragment = new SampleDialogFragment();
                dlgFragment.show(getSupportFragmentManager(), "sample_dialog_fragment");
            }
        });
    }
}
