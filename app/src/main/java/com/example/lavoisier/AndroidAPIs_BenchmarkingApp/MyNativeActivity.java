package com.example.lavoisier.AndroidAPIs_BenchmarkingApp;

import android.os.Bundle;
import android.util.Log;
import android.app.NativeActivity;

//import com.example.lavoisier.test_tracer_app.R;

public class MyNativeActivity extends  NativeActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Method called for test
        this.getVolumeControlStream();
        Log.i("getVolumeControlStream", "\n  NativeActivity->getVolumeControlStream called ");

        /*setContentView(R.layout.activity_my_native);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

}
