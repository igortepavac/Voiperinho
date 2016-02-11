package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.mvp.interactors.RegisterInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.RegisterListener;
import xyz.thedevspot.voiperinho.network.api.ApiManager;

/**
 * Created by foi on 06/01/16.
 */
public class RegisterInteractorImpl implements RegisterInteractor {

    private RegisterListener listener;

    @Override
    public void attemptRegistration(RegisterListener listener, RegisterRequest registerRequest) {
        this.listener = listener;

        Call<BaseResponse<String>> call = ApiManager.getService().userRegister(registerRequest);
        call.enqueue(callback);
    }

    private Callback<BaseResponse<String>> callback = new Callback<BaseResponse<String>>() {
        @Override
        public void onResponse(Response<BaseResponse<String>> response, Retrofit retrofit) {
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
