package com.example.vishnu.retro_trail.config;

import android.app.Application;
import android.os.StrictMode;

public class AppController extends Application {
    public static final String TAG = AppController.class.getSimpleName();
    private static AppController mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }
}
