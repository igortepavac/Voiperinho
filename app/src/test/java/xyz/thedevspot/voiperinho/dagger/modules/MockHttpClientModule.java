package xyz.thedevspot.voiperinho.dagger.modules;

import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.ExecutorService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by foi on 15/02/16.
 */

@Module
public class MockHttpClientModule {

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient(ExecutorService service) {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setDispatcher(new Dispatcher(service));
        return httpClient;
    }
}
