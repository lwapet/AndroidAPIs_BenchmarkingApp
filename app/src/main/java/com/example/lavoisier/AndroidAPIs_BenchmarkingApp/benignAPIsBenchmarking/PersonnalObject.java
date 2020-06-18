package com.example.lavoisier.AndroidAPIs_BenchmarkingApp.benignAPIsBenchmarking;

import android.util.Log;

public class PersonnalObject {
    int field ;
    public  PersonnalObject(){
        field = 0;
    }
    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        buf.append( "Personnal object value   = " + field);
        testIfToStringHasBeenCalled();
        return buf.toString();
    }
    public void testIfToStringHasBeenCalled()
    {
        Log.i("PersonnalObject", " Testing class java.lang.Object -> method toString(String) , calling testIfToStringHasBeenCalled()");
    }
}
