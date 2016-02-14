package xyz.thedevspot.voiperinho.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class HostModule {

    private static final String URL = "http://thedevspot.xyz:90";

    @Provides
    @Singleton
    public String provideBaseUrl() {
        return URL;
    }
}
