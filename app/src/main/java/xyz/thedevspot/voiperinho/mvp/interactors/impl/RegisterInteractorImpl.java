package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.listeners.Listener;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.mvp.interactors.RegisterInteractor;
import xyz.thedevspot.voiperinho.network.ApiService;

/**
 * Created by foi on 06/01/16.
 */
public class RegisterInteractorImpl implements RegisterInteractor {

    private Listener<Void> listener;

    private ApiService apiService;

    @Inject
    public RegisterInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void attemptRegistration(Listener<Void> listener, RegisterRequest registerRequest) {
        this.listener = listener;

        Call<BaseResponse<String>> call = apiService.userRegister(registerRequest);
        call.enqueue(callback);
    }

    private Callback<BaseResponse<String>> callback = new Callback<BaseResponse<String>>() {
        @Override
        public void onResponse(Response<BaseResponse<String>> response, Retrofit retrofit) {
            if (response.body().getStatus() == 200) {
                listener.onSuccess(null);
            } else {
                listener.onFailure();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            listener.onFailure();
        }
    };
}
