package xyz.thedevspot.voiperinho.dagger.modules;

import dagger.Module;
import dagger.Provides;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.network.ApiService;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class NetworkModule {

    @Provides
    public ApiService provideApiService() {
        return VoiperinhoApplication.getInstance().getApiService();
    }
}
