package com.example.lavoisier.AndroidAPIs_BenchmarkingApp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

//import com.example.lavoisier.test_tracer_app.R;

public class MainActivity extends AppCompatActivity {

     public static String EXTRA_MESSAGE = "extraData";
    private static final String TAG = "TESTING APIS : Main";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Context context = MainActivity.this;

        Button start_benign_apis_benchmarking_activity = (Button) findViewById(R.id.start_benign_apis_benchmarking_activity);
        start_benign_apis_benchmarking_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeningAPIsBenchmarkingActivity.class);
                startActivity(intent);

            }
        });


        Button start_malicious_apis_benchmarking_activity = (Button) findViewById(R.id.start_malicious_apis_benchmarking_activity);
        start_malicious_apis_benchmarking_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeningAPIsBenchmarkingActivity.class);
                startActivity(intent);

            }
        });









        // testing the android.openlgl.Matrix.GetClass() ; I followed this tutorial https://www.learnopengles.com/android-lesson-one-getting-started/
        // source code https://github.com/learnopengles/Learn-OpenGLES-Tutorials/tree/master/android/AndroidOpenGLESLessons/app/src/main/java/com/learnopengles/android/lesson1
        // So I implemented an activity witch can be triggered by pressing the button "test open gl matrix"

        Button button_start_openGl = findViewById(R.id.test_opengl_activity);
        button_start_openGl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OpenGlActivity.class);
                startActivity(intent);
                Log.i(TAG, "\n Button start Open Gl Clicked ");
            }
        });

        String[] androidVersionNames = {"Aestro", "Blender", "CupCake", "Donut", "Eclair", "Froyo", "Gingerbread", "HoneyComb", "IceCream Sandwich", "Jellibean", "Kitkat", "Lollipop", "MarshMallow"};
        // Testing AutoCompleteTextView
        // from tutorial https://abhiandroid.com/ui/multiautocompletetextview
        MultiAutoCompleteTextView simpleMultiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        // set adapter to fill the data in suggestion list
        ArrayAdapter<String> versionNames = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, androidVersionNames);
        simpleMultiAutoCompleteTextView.setAdapter(versionNames);

        // set threshold value 1 that help us to start the searching from first character
        simpleMultiAutoCompleteTextView.setThreshold(1);
        // set tokenizer that distinguish the various substrings by comma
        simpleMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        Log.i(TAG, "\n  Testing the function  MultiAutoCompleteTextView.saveHierarchyState");
        SparseArray<Parcelable> hierarchyState = new SparseArray<>();
        simpleMultiAutoCompleteTextView.saveHierarchyState(hierarchyState);


        // Now testing ViewStructure.setCheckable()


    }

    // Testing class android.app.Activity -> init(), by starting another activity
    /** To test the activity startup
     * Called when the user tap on start another activity*/
    public void startAnotherActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /*public void startOpenGlActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }*/


    @Override
    protected void onStart() {
        super.onStart();
        Button fab = (Button) findViewById(R.id.test_jni);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action activity onstart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                TextView centralText = (TextView)findViewById(R.id.sample_text);
                String libraryPath = ApplicationContextProvider.getContext().getApplicationInfo().dataDir + "/lib";

                centralText.setText(" OnStart Called !" );
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
