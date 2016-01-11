package xyz.thedevspot.voiperinho.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by foi on 06/01/16.
 */
public class SharedPreferencesHelper {

    private static final String PACKAGE = "xyz.thedevspot.voiperinho";

    private static final String USER_ID = "user_id";

    private static final String CONTACT_ID = "contact_id";

    private static SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
    }

    public static void setUserId(Context context, int id) {
        SharedPreferences prefs = getSharedPrefs(context);
        prefs.edit().putInt(USER_ID, id).apply();
    }

    public static int getUserId(Context context) {
        return getSharedPrefs(context).getInt(USER_ID, 0);
    }

    public static void setContactId(Context context, int id) {
        SharedPreferences prefs = getSharedPrefs(context);
        prefs.edit().putInt(CONTACT_ID, id);
    }

    public static int getContactId(Context context) {
        return getSharedPrefs(context).getInt(CONTACT_ID, 0);
    }

}
