package com.manichord.uartbridge;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import mortar.MortarScope;
import timber.log.Timber;

/**
 * Custom Application singleton
 */

public class UartApplication extends Application {

    private MortarScope rootScope;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            //TODO: Timber.plant(new CrashReportingTree());
        }
    }

    @Override
    public Object getSystemService(String name) {
        if (rootScope == null) {
            rootScope = MortarScope.buildRootScope()
                    .withService(PrefHelper.class.getName(), PrefHelper.newInstance(this))
                    .build("Root");
        }
        return rootScope.hasService(name) ? rootScope.getService(name) : super.getSystemService(name);
    }
}
