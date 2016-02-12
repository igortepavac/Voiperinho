package xyz.thedevspot.voiperinho.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import xyz.thedevspot.voiperinho.VoiperinhoApplication;

/**
 * Created by foi on 06/01/16.
 */
public class SharedPreferencesHelper {

    private static final String PACKAGE = "xyz.thedevspot.voiperinho";

    public static final String USER_ID = "user_id";

    public static final String USER = "user";

    public static final String CONTACT_ID = "contact_id";

    public static final String CONTACT = "contact";

    private static SharedPreferences sharedPrefs;

    private static SharedPreferences getSharedPrefs() {
        if (sharedPrefs == null) {
            sharedPrefs = VoiperinhoApplication.getInstance().getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        }
        return sharedPrefs;
    }

    public static void setString(String value, String key) {
        getSharedPrefs().edit().putString(key, value).apply();
    }

    public static String getString(String key) {
        return getSharedPrefs().getString(key, "");
    }

    public static void setInt(int value, String key) {
        getSharedPrefs().edit().putInt(key, value).apply();
    }

    public static int getInt(String key) {
        return getSharedPrefs().getInt(key, 0);
    }
}
