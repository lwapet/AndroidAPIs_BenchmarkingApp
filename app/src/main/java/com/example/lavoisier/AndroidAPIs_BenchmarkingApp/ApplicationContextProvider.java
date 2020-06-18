package com.example.lavoisier.AndroidAPIs_BenchmarkingApp;

import android.app.Application;
import android.content.Context;

public class ApplicationContextProvider extends Application {

    public int getManipDuration(){
        return manipDuration;
    }

    public String getAnalysedAppPackagePath() {
        return analysedAppPackagePath;
    }

    public void setAnalysedAppPackagePath(String analysedAppPackagePath) {
        this.analysedAppPackagePath = analysedAppPackagePath;
    }

    public String getAnalysedAppPackageName() {
        return analysedAppPackageName;
    }

    public void setAnalysedAppPackageName(String analysedAppPackageName) {
        this.analysedAppPackageName = analysedAppPackageName;
    }

    /**
     * Keeps a reference of the application context
     */
    String analysedAppPackagePath = null, analysedAppPackageName = null;
    int manipDuration = 10000; // 120 000 ms or 2 min

    public String getOdileGUIPath() {
        return odileGUIPath;
    }

    public void setOdileGUIPath(String odileGUIPath) {
        this.odileGUIPath = odileGUIPath;
    }

    String odileGUIPath;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

    }

    /**
     * Returns the application context
     *
     * @return application context
     */
    public static Context getContext() {
        return sContext;
    }

}