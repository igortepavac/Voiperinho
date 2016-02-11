package xyz.thedevspot.voiperinho.network.api;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by foi on 06/01/16.
 */
public class ApiManager {

    private static final String API_ENDPOINT = "http://thedevspot.xyz:90";

    private static Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .client(new OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final VoiperinhoService SERVICE = RETROFIT.create(VoiperinhoService.class);

    public static VoiperinhoService getService() {
        return SERVICE;
    }


}
