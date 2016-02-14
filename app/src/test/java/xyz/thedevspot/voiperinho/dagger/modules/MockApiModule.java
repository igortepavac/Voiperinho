package xyz.thedevspot.voiperinho.dagger.modules;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Converter;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.network.ApiService;

/**
 * Created by foi on 14/02/16.
 */

@Module
public class MockApiModule {

    @Provides
    @Singleton
    public ApiService provideApiService(String baseUrl, Converter.Factory converterFactory,
                                        OkHttpClient okHttpClient, Executor callbackExecutor) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .callbackExecutor(callbackExecutor)
                .build();

        return retrofit.create(ApiService.class);
    }
}
