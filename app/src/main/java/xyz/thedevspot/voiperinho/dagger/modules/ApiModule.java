package xyz.thedevspot.voiperinho.dagger.modules;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Converter;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.network.ApiService;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    public ApiService provideApiService(String baseUrl, Converter.Factory converterFactory, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }
}
