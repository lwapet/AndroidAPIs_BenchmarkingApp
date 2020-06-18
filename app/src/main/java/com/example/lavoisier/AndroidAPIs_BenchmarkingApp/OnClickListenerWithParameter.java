package com.example.lavoisier.AndroidAPIs_BenchmarkingApp;

import android.app.Activity;
import android.view.View;

//HelperClass to retrieve some parameters when the test start as the number of tests...
public class OnClickListenerWithParameter implements View.OnClickListener
{
    int numberOfCalls;
    Activity context;
    public OnClickListenerWithParameter(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }
    public OnClickListenerWithParameter(Activity context) {
        this.context = context;
    }
    @Override
    public void onClick(View v)
    {
    }
};