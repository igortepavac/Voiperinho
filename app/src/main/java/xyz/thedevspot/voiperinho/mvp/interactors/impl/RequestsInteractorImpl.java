package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.RequestInformation;
import xyz.thedevspot.voiperinho.mvp.interactors.RequestsInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.RequestsListener;
import xyz.thedevspot.voiperinho.network.api.ApiManager;

/**
 * Created by foi on 10/01/16.
 */
public class RequestsInteractorImpl implements RequestsInteractor {

    private RequestsListener listener;

    @Override
    public void getRequests(RequestsListener listener) {
        this.listener = listener;
        int id = SharedPreferencesHelper.getUserId(VoiperinhoApplication.getInstance());

        Call<BaseResponse<List<RequestInformation>>> call = ApiManager.getService().getRequests(id);
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
                listener.onRequestsReceived(response.body().getMessage());
            } else {
                listener.onError();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            listener.onError();
        }
    };
}
