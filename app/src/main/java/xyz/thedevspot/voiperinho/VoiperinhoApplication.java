package xyz.thedevspot.voiperinho;

import android.app.Application;

/**
 * Created by foi on 06/01/16.
 */
public class VoiperinhoApplication extends Application {

    private static VoiperinhoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static VoiperinhoApplication getInstance() {
        return instance;
    }
}
