package com.example.lavoisier.AndroidAPIs_BenchmarkingApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lavoisier.AndroidAPIs_BenchmarkingApp.benignAPIsBenchmarking.PersonnalObject;

import java.util.ArrayList;
import java.util.Iterator;

// 1- Apis from the paper : Android Malware Detection based on Useful API Calls and Machine Learning
public class BeningAPIsBenchmarkingActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bening_apis_benchmarking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.bening_apis_benchmarking);
        setSupportActionBar(toolbar);

        //-----.-----.-----.Testing class java.lang.Object -> method testIfToStringHasBeenCalled()-----.-----.-----.
        Button info_button_api_java_lang_Object_toString = (Button) findViewById(R.id.info_button_api_java_lang_Object_toString);
        // Informations
        info_button_api_java_lang_Object_toString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API  java.lang.Object -> method toString()",
                        "Implemenation: We overloaded toString() to be sure it will be called on a custom object\n" +
                                "How to use: Just give the number of repetitive call you want to use\n" +
                                "Verify the call: in the log, just search the tag PersonnalObject");
            }
        });

        // ActionOnBenchmark
        Button startTest_api_java_lang_Object_toString = (Button) findViewById(R.id.startTest_api_java_lang_Object_toString);
        startTest_api_java_lang_Object_toString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Number of calls
                EditText editText = findViewById(R.id.numberOfTest_api_java_lang_Object_toString);
                String temp = editText.getText().toString();
                int value=1;
                if (!"".equals(temp)){
                    value=Integer.parseInt(temp);
                }
                for(int i = 0; i<= value; i++){
                    PersonnalObject object1 = new PersonnalObject();
                    object1.toString();
                }
                showAlertDialog("Informations about the API  java.lang.Object -> method toString()",
                        "API correctly tested " + value + " times");
            }
        });







        //-----.-----.-----.Testing class  java.lang.StringBuilder ->  append(String) append (Int) , toString()-----.-----.-----.
        Button info_button_api_java_lang_stringBuilder_appendS_appendI_toString = (Button) findViewById(R.id.info_button_api_java_lang_stringBuilder_appendS_appendI_toString);
        // Informations
        info_button_api_java_lang_stringBuilder_appendS_appendI_toString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API java.lang.StringBuilder ->  append(String) append (Int) , toString() \"",
                        "Implemenation: We just implemented the api class java.lang.StringBuilder \n" +
                                "How to use: Just give the number of repetitive call you want to use\n" +
                                "Verify the call: in the log, just search the tag \"java.lang.StringBuilder\"");

            }
        });

        // ActionOnBenchmark
        Button startTest_api_java_lang_stringBuilder_appendS_appendI_toString = (Button) findViewById(R.id.startTest_api_java_lang_stringBuilder_appendS_appendI_toString);
        startTest_api_java_lang_stringBuilder_appendS_appendI_toString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Number of calls
                EditText editText_api_java_lang_stringBuilder_appendS_appendI_toString = findViewById(R.id.numberOfTest_api_java_lang_Object_toString);
                String temp_api_java_lang_stringBuilder_appendS_appendI_toString = editText_api_java_lang_stringBuilder_appendS_appendI_toString.getText().toString();
                int value_api_java_lang_stringBuilder_appendS_appendI_toString=1;
                if (!"".equals(temp_api_java_lang_stringBuilder_appendS_appendI_toString)){
                    value_api_java_lang_stringBuilder_appendS_appendI_toString=Integer.parseInt(temp_api_java_lang_stringBuilder_appendS_appendI_toString);
                }
                for(int i = 0; i<= value_api_java_lang_stringBuilder_appendS_appendI_toString; i++){
                    StringBuilder str = new StringBuilder("test");
                    Log.i("java.lang.StringBuilder", "\n  Calling append on String ");
                    str.append("string appended");
                    Log.i("java.lang.StringBuilder", "\n  Calling append on Int ");
                    str.append(1000);
                    Log.i("java.lang.StringBuilder", "\n  Calling toString " +  str.toString());
                }
                showAlertDialog("Informations about the API java.lang.StringBuilder ->  append(String) append (Int) , toString() \"",
                        "API correctly tested");
            }
        });



        //-----.-----.-----.Testing tht API name :  java.lang.string -> equals-----.-----.-----.
        Button info_button_api_java_lang_string_method_equal = (Button) findViewById(R.id.info_button_api_java_lang_string_method_equal);
        // Informations
        info_button_api_java_lang_string_method_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API name :  java.lang.string -> equals  \"",
                        "Implemenation: We just implemented the api API name :  java.lang.string -> equals \n" +
                                "How to use: Just give the number of repetitive call you want to use\n" +
                                "Verify the call: in the log, just search the tag \"java.lang.string equals\"");
            }
        });

        // ActionOnBenchmark
        Button startTest_api_java_lang_string_method_equal = (Button) findViewById(R.id.startTest_api_java_lang_string_method_equal);
        startTest_api_java_lang_string_method_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Number of calls
                EditText editText_api_java_lang_string_method_equal = findViewById(R.id.numberOfTest_api_java_lang_string_method_equal);
                String temp_api_java_lang_string_method_equal = editText_api_java_lang_string_method_equal.getText().toString();
                int value_api_java_lang_string_method_equal = 1;
                if (!"".equals(temp_api_java_lang_string_method_equal)){
                    value_api_java_lang_string_method_equal = Integer.parseInt(temp_api_java_lang_string_method_equal);
                }
                for(int i = 0; i<= value_api_java_lang_string_method_equal; i++){
                    String myString1 = "testing String equals";
                    String myString2 = "testing String equals";
                    if(myString1.equals(myString2)) {
                        Log.i("java.lang.string equals", " testing Java.Lang.String equals() true");
                    } else{
                        Log.i("java.lang.string equals", " testing Java.Lang.String equals() false");
                    }
                }
                showAlertDialog("Informations about the API name :  java.lang.string -> equals  \"",
                        "API correctly tested");
            }
        });




        //-----.-----.-----.Testing tht API name :  java.util.ArrayList -> init() -----.-----.-----.
        Button info_button_api_java_util_arrayList_Iterator = (Button) findViewById(R.id.info_button_api_java_util_arrayList_Iterator);
        // Informations
        info_button_api_java_util_arrayList_Iterator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API name :   java.util.ArrayList -> init() and java.util.Iterator -> next() , hasNext()  \"",
                        "Implemenation: We instanciated an ArrayList, add some strings to It and iterate over those strings \n" +
                                "How to use: Just give the number of repetitive call you want to use\n" +
                                "Verify the call: in the log, just search the tag \"java.util.ArrayList\"");
            }
        });

        // ActionOnBenchmark
        Button startTest_api_java_util_arrayList_Iterator = (Button) findViewById(R.id.startTest_api_java_util_arrayList_Iterator);
        startTest_api_java_lang_string_method_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Number of calls
                EditText editText_api_java_util_arrayList_Iterator = findViewById(R.id.numberOfTest_api_java_util_arrayList_Iterator);
                String temp_api_java_util_arrayList_Iterator = editText_api_java_util_arrayList_Iterator.getText().toString();
                int value_api_java_util_arrayList_Iterator = 1;
                if (!"".equals(temp_api_java_util_arrayList_Iterator)){
                    value_api_java_util_arrayList_Iterator = Integer.parseInt(temp_api_java_util_arrayList_Iterator);
                }
                for(int i = 0; i<= value_api_java_util_arrayList_Iterator; i++){
                    // testing java.util.ArrayList -> init equals
                    ArrayList<String> list = new ArrayList<>();
                    list.add("Testing");
                    list.add("Array");
                    list.add("List");
                    // Displaying the list
                    Log.i("java.util.ArrayList", "The list is: \n" + list);
                    // Create an iterator for the list
                    // using iterator() method
                    Iterator<String> iter = list.iterator();
                    // Displaying the values after iterating
                    // through the list
                    Log.i("java.util.ArrayList", "\nThe iterator values" + " of list are: ");
                    while (iter.hasNext()) {
                        System.out.print(iter.next() + " ");
                    }

                }
                showAlertDialog("Informations about the API name :   java.util.ArrayList -> init() and java.util.Iterator -> next() , hasNext()  \"",
                        "API correctly tested");
            }
        });






















    }









    public void showAlertDialog(String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(BeningAPIsBenchmarkingActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        finish();
                    }
                })
                .show();

    }
















}
