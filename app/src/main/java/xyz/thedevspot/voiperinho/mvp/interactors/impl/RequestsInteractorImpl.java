package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import java.util.List;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.listeners.Listener;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.RequestInformation;
import xyz.thedevspot.voiperinho.mvp.interactors.RequestsInteractor;
import xyz.thedevspot.voiperinho.network.ApiService;

/**
 * Created by foi on 10/01/16.
 */
public class RequestsInteractorImpl implements RequestsInteractor {

    private Listener<List<RequestInformation>> listener;

    private ApiService apiService;

    @Inject
    public RequestsInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getRequests(Listener<List<RequestInformation>> listener) {
        this.listener = listener;
        int id = SharedPreferencesHelper.getInt(SharedPreferencesHelper.USER_ID);

        Call<BaseResponse<List<RequestInformation>>> call = apiService.getRequests(id);
        call.enqueue(requestsCallback);
    }

    @Override
    public void acceptRequest(boolean accept) {

        // TODO: accept/deny request
    }

    private Callback<BaseResponse<List<RequestInformation>>> requestsCallback = new Callback<BaseResponse<List<RequestInformation>>>() {
        @Override
        public void onResponse(Response<BaseResponse<List<RequestInformation>>> response, Retrofit retrofit) {
            if (response.body().getStatus() == 200) {
                listener.onSuccess(response.body().getMessage());
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
