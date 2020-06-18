package com.example.lavoisier.AndroidAPIs_BenchmarkingApp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import android.service.carrier.CarrierService;
import android.os.PersistableBundle;
import android.service.carrier.CarrierIdentifier;
import android.telephony.CarrierConfigManager;

@TargetApi(Build.VERSION_CODES.M)
@RequiresApi(api = Build.VERSION_CODES.M)
public class SampleCarrierConfigService extends CarrierService {
    private static final String TAG = "SampleCarrierConfigService";

    @SuppressLint("LongLogTag")
    public SampleCarrierConfigService() {
        Log.d(TAG, "Service created");
    }

    @SuppressLint({"LongLogTag", "WrongConstant"})
    @Override
    public PersistableBundle onLoadConfig(CarrierIdentifier id) {
        if (id.describeContents() == 2){
            Log.d(TAG, "--- Trigger received from MainActivity");
        }
        Log.d(TAG, "Config being fetched");
        PersistableBundle config = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            config = new PersistableBundle();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            config.putBoolean(
                    CarrierConfigManager.KEY_CARRIER_VOLTE_AVAILABLE_BOOL, true);
            config.putBoolean(
                    CarrierConfigManager.KEY_CARRIER_VOLTE_TTY_SUPPORTED_BOOL, false);
            config.putInt(CarrierConfigManager.KEY_VOLTE_REPLACEMENT_RAT_INT, 6);
            // Check CarrierIdentifier and add more config if needed…
        }
        if (id.describeContents() == 2){
            Log.d(TAG, "--- Trying to call stopSelf");
            this.stopSelf();
            Log.d(TAG, "--- The API is correctly tested");
        }

        return config;
    }



}
