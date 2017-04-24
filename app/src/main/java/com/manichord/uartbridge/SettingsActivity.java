package com.manichord.uartbridge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 *
 */

public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    protected void onResume() {
        super.onResume();
        PrefHelper prefs = (PrefHelper) getApplicationContext().getSystemService(PrefHelper.class.getName());
        prefs.registerListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PrefHelper prefs = (PrefHelper) getApplicationContext().getSystemService(PrefHelper.class.getName());
        prefs.unRegisterListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Intent intent = UsbService.getIntent(this);
        stopService(intent);
        startService(intent); // ReStart UsbService
    }

}
