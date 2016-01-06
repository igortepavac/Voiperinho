package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.models.Credentials;
import xyz.thedevspot.voiperinho.models.LoginResponse;
import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;
import xyz.thedevspot.voiperinho.network.ApiManager;

/**
 * Created by foi on 06/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener listener;

    @Override
    public void attemptLogin(LoginListener listener, String username, String password) {
        this.listener = listener;
        Credentials credentials = new Credentials(username, password);

        Call<LoginResponse> call = ApiManager.getService().userLogin(credentials);
        call.enqueue(callback);
    }

    private Callback<LoginResponse> callback = new Callback<LoginResponse>() {
        @Override
        public void onResponse(Response<LoginResponse> response, Retrofit retrofit) {
            SharedPreferencesHelper.setId(
                    VoiperinhoApplication.getInstance(), response.body().getMessage().getId());
            listener.onLoginSuccess();
        }

        @Override
        public void onFailure(Throwable t) {
            listener.onLoginFail();
        }
    };
}
