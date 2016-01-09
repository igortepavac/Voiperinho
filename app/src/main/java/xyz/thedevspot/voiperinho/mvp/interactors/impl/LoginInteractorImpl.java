package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;

/**
 * Created by foi on 06/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener listener;

    @Override
    public void attemptLogin(LoginListener listener, String username, String password) {
        this.listener = listener;
        String credentials = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }\n";

        // TODO: login with socket

        //Call<LoginResponse> call = ApiManager.getService().userLogin(credentials);
        //call.enqueue(callback);
    }

    /*
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
    */
}
