package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.models.RegisterResponse;
import xyz.thedevspot.voiperinho.mvp.interactors.RegisterInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.RegisterListener;
import xyz.thedevspot.voiperinho.network.ApiManager;

/**
 * Created by foi on 06/01/16.
 */
public class RegisterInteractorImpl implements RegisterInteractor {

    private RegisterListener listener;

    @Override
    public void attemptRegistration(RegisterListener listener, RegisterRequest registerRequest) {
        this.listener = listener;

        Call<RegisterResponse> call = ApiManager.getService().userRegister(registerRequest);
        call.enqueue(callback);
    }

    private Callback<RegisterResponse> callback = new Callback<RegisterResponse>() {
        @Override
        public void onResponse(Response<RegisterResponse> response, Retrofit retrofit) {
            if (response.body().getStatus() == 200) {
                listener.onRegisterSuccess();
            } else {
                listener.onRegisterFail();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            listener.onRegisterFail();
        }
    };
}
