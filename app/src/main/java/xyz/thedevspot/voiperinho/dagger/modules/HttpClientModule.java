package xyz.thedevspot.voiperinho.dagger.modules;

import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by foi on 14/02/16.
 */

@Module
public class HttpClientModule {

    @Provides
    public OkHttpClient providesHttpClient() {
        return new OkHttpClient();
    }
}
