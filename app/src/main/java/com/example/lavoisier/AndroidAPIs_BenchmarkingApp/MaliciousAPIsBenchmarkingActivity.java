package com.example.lavoisier.AndroidAPIs_BenchmarkingApp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;

public class MaliciousAPIsBenchmarkingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malicious_apis_benchmarking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.malicious_apis_benchmarking);
        setSupportActionBar(toolbar);


        //-----.-----.-----.Testing javax.sql.ConnectionEvent -> init-----.-----.-----.
        Button info_button_api_javax_sql_ConnectionEvent = (Button) findViewById(R.id.info_button_api_javax_sql_ConnectionEvent);
        // Informations
        info_button_api_javax_sql_ConnectionEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API  javax.sql.ConnectionEvent -> init",
                        "Implemenation: We instanciated the javax.sql.ConnectionEvent  object knowing that it will call the init method" +
                                "How to use: Just give the number of repetitive call you want to use\n" +
                                "Verify the call: in the log, just search the tag ConnectionEvent");
            }
        });

        // ActionOnBenchmark
        Button startTest_api_javax_sql_ConnectionEvent = (Button) findViewById(R.id.startTest_api_javax_sql_ConnectionEvent);
        startTest_api_javax_sql_ConnectionEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Number of calls
                EditText editText_api_javax_sql_ConnectionEvent = findViewById(R.id.numberOfTest_api_javax_sql_ConnectionEvent);
                String temp_api_javax_sql_ConnectionEvent = editText_api_javax_sql_ConnectionEvent.getText().toString();
                int value_api_javax_sql_ConnectionEvent=1;
                if (!"".equals(temp_api_javax_sql_ConnectionEvent)){
                    value_api_javax_sql_ConnectionEvent=Integer.parseInt(temp_api_javax_sql_ConnectionEvent);
                }
                for(int i = 0; i<= value_api_javax_sql_ConnectionEvent; i++){
                    Log.i("ConnectionEvent", "\n Testing javax.sql.ConnectionEvent -> init ");
                    ConnectionEvent e = new  ConnectionEvent(
                        new PooledConnection() {
                            @Override
                            public Connection getConnection() throws SQLException {
                                return null;
                            }

                            @Override
                            public void close() throws SQLException {

                            }

                            @Override
                            public void addConnectionEventListener(ConnectionEventListener listener) {

                            }

                            @Override
                            public void removeConnectionEventListener(ConnectionEventListener listener) {

                            }

                            @Override
                            public void addStatementEventListener(StatementEventListener listener) {

                            }

                            @Override
                            public void removeStatementEventListener(StatementEventListener listener) {

                            }
                        },new SQLException());
                }
                showAlertDialog("Informations about the API  javax.sql.ConnectionEvent -> init","API correctly tested");
            }
        });


        //-----.-----.-----.Testing java.nio.channels.WritableBytesChannel -> close -----.-----.-----.
        Button info_button_api_java_nio_channels_WritableBytesChannel_close = (Button) findViewById(R.id.info_button_api_java_nio_channels_WritableBytesChannel_close);
        // Informations
        info_button_api_java_nio_channels_WritableBytesChannel_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API  java.nio.channels.WritableBytesChannel -> close",
                        "Implemenation: We instanciated the java.nio.channels.WritableBytesChannel -> close " +
                                "How to use: Just give the number of repetitive call you want to use\n" +
                                "Verify the call: in the log, search for the tag WritableBytesChannel");
            }
        });

        // ActionOnBenchmark
        Button startTest_api_java_nio_channels_WritableBytesChannel_close = (Button) findViewById(R.id.startTest_api_java_nio_channels_WritableBytesChannel_close);
        startTest_api_java_nio_channels_WritableBytesChannel_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Number of calls
                EditText editText_api_java_nio_channels_WritableBytesChannel_close = findViewById(R.id.numberOfTest_api_java_nio_channels_WritableBytesChannel_close);
                String temp_api_java_nio_channels_WritableBytesChannel_close = editText_api_java_nio_channels_WritableBytesChannel_close.getText().toString();
                int value_api_java_nio_channels_WritableBytesChannel_close=1;
                if (!"".equals(temp_api_java_nio_channels_WritableBytesChannel_close)){
                    value_api_java_nio_channels_WritableBytesChannel_close=Integer.parseInt(temp_api_java_nio_channels_WritableBytesChannel_close);
                }
                for(int i = 0; i<= value_api_java_nio_channels_WritableBytesChannel_close; i++){
                    // testing java.nio.channels.WritableBytesChannel -> close (from https://stackoverflow.com/questions/1239026/how-to-create-a-file-in-android)
                    Log.i("WritableBytesChannel", "\n Testing java.nio.channels.WritableBytesChannel -> close ");
                    FileInputStream input = null;
                    try {
                        Log.i("WritableBytesChannel", "\n Creating test files ");
                        String internalStorage = getFilesDir().getAbsolutePath();
                        File fileIn = new File(internalStorage + "/testIn.txt");
                        File fileOut = new File(internalStorage + "/testOut.txt");
                        fileIn.createNewFile();
                        fileOut.createNewFile();
                        byte[] data1={1,1,0,0};
                        if(fileIn.exists())
                        {
                            FileOutputStream fo = new FileOutputStream(fileIn);
                            fo.write(data1);
                            fo.close();
                        }
                        Log.i("WritableBytesChannel", "\n reading the source file ");
                        input = new FileInputStream(fileIn);
                        ReadableByteChannel source = input.getChannel();
                        FileOutputStream output = new FileOutputStream (fileOut);
                        WritableByteChannel dest = output.getChannel();
                        Log.i("WritableBytesChannel", "\n  Copying datas from source to destination file using Channels ");
                        copyData(source, dest);
                        Log.i("WritableBytesChannel", "\n  Calling close method ");
                        source.close();
                        dest.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                showAlertDialog("Informations about the API  java.nio.channels.WritableBytesChannel -> close","API correctly tested");
            }
        });






        //-----.-----.-----.Testing java.nio.channels.WritableBytesChannel -> close -----.-----.-----.
        Button info_button_api_android_service_carrier_CarrierService_stopSelf_V = (Button) findViewById(R.id.info_button_api_android_service_carrier_CarrierService_stopSelf_V);
        // Informations
        info_button_api_android_service_carrier_CarrierService_stopSelf_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API  Landroid.service.carrier.CarrierService.stopSelf:()V",
                                "\n caution: to properly use Carrier functionnality, we should sign this application with the same signature as the one used to configure the SIM/UICC card." +
                                        "But we do not have the technology to build one or to modify one's signature with our certificate." +
                        "Implemenation: We just trigger the Carrier service enought to generate a security exception." +
                                        "The code we implemented will trigger the onLoadConfig of SampleCarrierConfigService" +
                                "How to use: Click on the button to start the test (send one notification), you can click many times as you want\n" +
                                "Verify the call: in the log, search for the tag SampleCarrierConfigService and stopSelf");
            }
        });

        // ActionOnBenchmark
        Button startTest_api_android_service_carrier_CarrierService_stopSelf_V = (Button) findViewById(R.id.startTest_api_android_service_carrier_CarrierService_stopSelf_V);
        startTest_api_android_service_carrier_CarrierService_stopSelf_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Testing Landroid.service.carrier.CarrierService.stopSelf:()V
                // We just trigger the Carrier service enought to generate a security exception because
                // to properly use Carrier functionnality, we should sign this application with the same signature as the one used to configure the SIM/UICC card.
                // But we do not have the technology to build one or to modify one's signature with our certificate.
                // This code will trigger the onLoadConfig of SampleCarrierConfigService

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    ((CarrierConfigManager) MaliciousAPIsBenchmarkingActivity.this.getApplicationContext().getSystemService(Context.CARRIER_CONFIG_SERVICE)).notifyConfigChangedForSubId(SubscriptionManager.getDefaultSubscriptionId());
                }

                showAlertDialog("Informations about the API Landroid.service.carrier.CarrierService.stopSelf:()V"," the notification has been sent");
            }
        });



        //-----.-----.-----.Testing  NativeActivity->getVolumeControlStream -----.-----.-----.
        Button info_button_api_Native_Activity_getVolumeControlStream = (Button) findViewById(R.id.info_button_api_Native_Activity_getVolumeControlStream);
        // Informations
        info_button_api_Native_Activity_getVolumeControlStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API NativeActivity->getVolumeControlStream",
                                "Implemenation: We triggered the MyNativeActivity startup. It calls the method getVolumeControlStream in his onCreate() method." +
                                        " It also extends android.app.NativeActivity linked to the native-lib  we implemented in C." +
                                "How to use: Click on the button to start the activiy\n" +
                                "Verify the call: in the log, search for the tag getVolumeControlStream ");
            }
        });
        // ActionExecuted whenOnBenchmark
        Button startTest_api_Native_Activity_getVolumeControlStream = (Button) findViewById(R.id.startTest_api_Native_Activity_getVolumeControlStream);
        startTest_api_Native_Activity_getVolumeControlStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Starting the native activity
                Intent intent = new Intent(getApplicationContext(), MyNativeActivity.class);
                startActivity(intent);
            }
        });



        //-----.-----.-----.testing the adapterView.refreshDrawableState() -- by clicking the button test adapter view(from https://www.tutorialspoint.com/android/android_list_view.htm)-----.-----.-----.
        Button info_button_api_adapterView_refreshDrawableState = (Button) findViewById(R.id.info_button_api_adapterView_refreshDrawableState);
        // Informations
        info_button_api_adapterView_refreshDrawableState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("Informations about the API adapterView->refreshDrawableState()",
                        "Implemenation: We extends an adapterView (it is the listView Below) and then refresh it (refreshDatabase)" +
                                "when you  click on the button to test." +
                                "How to use: Click on the button \"start the test\" to start the test \n" +
                                "Verify the call: in the log, search for the tag AdapterView ");
            }
        });
        // ActionOnBenchmark

        Button refresh_adapterView_refreshDrawableState = (Button) findViewById(R.id.refresh_adapterView_refreshDrawableState);
        /*startTest_api_adapterView_refreshDrawableState.setOnClickListener(new View.OnClickListener() {

        });*/
        refresh_adapterView_refreshDrawableState.setOnClickListener(new OnClickListenerWithParameter(this) {
            @Override
            public void onClick(View view) {
                String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
                        "WebOS","Ubuntu","Windows7","Max OS X"};

                ArrayAdapter adapter = new ArrayAdapter<String>(this.context, R.layout.activity_listview, mobileArray);

                ListView listView = (ListView) findViewById(R.id.adapter_view);
                listView.setAdapter(adapter);
                Button test_adapter_view = (Button) findViewById(R.id.startTest_api_adapterView_refreshDrawableState);
                test_adapter_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("AdapterView", "\n  Calling Testing the adapter view  ");
                        view.refreshDrawableState();
                    }
                });

            }
        });

    }











































    public void showAlertDialog(String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(MaliciousAPIsBenchmarkingActivity.this)
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
    private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException
    {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);

        while (src.read(buffer) != -1)
        {
            // Prepare the buffer to be drained
            buffer.flip();

            // Make sure that the buffer was fully drained
            while (buffer.hasRemaining())
            {
                dest.write(buffer);
            }

            // Make the buffer empty, ready for filling
            buffer.clear();
        }
    }
}
