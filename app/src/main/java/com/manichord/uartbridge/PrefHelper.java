package com.manichord.uartbridge;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

/**
 * Provide nicer interface to saving apps shard preferences.
 */

public class PrefHelper {

    private static final int DEFAULT_INT = 0;
    private static final String DEFAULT_STRING = "";
    private static final boolean DEFAULT_BOOLEAN = false;

    private SharedPreferences mPrefs;
    private Context mContext;


    public static PrefHelper newInstance(Context context) {
        return new PrefHelper(context);
    }

    private PrefHelper(Context context) {
        mContext = context;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void registerListener(SharedPreferences.OnSharedPreferenceChangeListener  listener) {
        mPrefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unRegisterListener(SharedPreferences.OnSharedPreferenceChangeListener  listener) {
        mPrefs.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public int getNetworkPort() {
        return getInt(mContext.getString(R.string.network_port_preference));
    }

    private void edit(String name, String value) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(name, value);
        editor.apply();
    }

    private void edit(String name, int value) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putInt(name, value);
        editor.apply();
    }

    private void edit(String name, boolean value) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putBoolean(name, value);
        editor.apply();
    }

    private String getString(String name) {
        return mPrefs.getString(name, DEFAULT_STRING);
    }

    private int getInt(String name) {
        return mPrefs.getInt(name, DEFAULT_INT);
    }

    private boolean getBoolean(String name) {
        return mPrefs.getBoolean(name, DEFAULT_BOOLEAN);
    }
}
