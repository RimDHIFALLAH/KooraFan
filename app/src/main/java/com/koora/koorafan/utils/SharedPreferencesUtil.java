package com.koora.koorafan.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.koora.koorafan.R;

public class SharedPreferencesUtil {
    private static SharedPreferences sharedPref;

    public static android.content.SharedPreferences getSharedPref(Context context) {
        if (sharedPref == null) {
            sharedPref = context.getSharedPreferences(
                    ("com.koora.koorafan"), Context.MODE_PRIVATE);
        }
        return sharedPref;
    }

    public static void writeStringToShared(Context context, String key, String value) {
        android.content.SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String readStringToShared(Context context, String key) {
        return getSharedPref(context).getString(key, "");
    }

    public static void clearCache(){
        sharedPref.edit().clear().commit();
    }
}
