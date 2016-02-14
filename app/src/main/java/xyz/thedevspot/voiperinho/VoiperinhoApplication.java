package xyz.thedevspot.voiperinho;

import android.app.Application;

import javax.inject.Inject;

import xyz.thedevspot.voiperinho.dagger.components.DaggerApplicationComponent;
import xyz.thedevspot.voiperinho.network.ApiService;

/**
 * Created by foi on 06/01/16.
 */
public class VoiperinhoApplication extends Application {

    protected static VoiperinhoApplication instance;

    @Inject
    ApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        DaggerApplicationComponent.create().inject(this);
    }

    public static VoiperinhoApplication getInstance() {
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }
}
