package xyz.thedevspot.voiperinho.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by foi on 06/01/16.
 */
public class SharedPreferencesHelper {

    private static final String PACKAGE = "xyz.thedevspot.voiperinho";

    private static final String ID = "id";

    private static SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
    }

    public static void setId(Context context, int id) {
        SharedPreferences prefs = getSharedPrefs(context);
        prefs.edit().putInt(ID, id).apply();
    }

    public static int getId(Context context) {
        return getSharedPrefs(context).getInt(ID, 0);
    }


}
