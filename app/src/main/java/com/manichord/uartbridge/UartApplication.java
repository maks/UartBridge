package com.manichord.uartbridge;

import android.app.Application;

import timber.log.Timber;

/**
 * Custom Application singleton
 */

public class UartApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            //TODO: Timber.plant(new CrashReportingTree());
        }

    }
}
