package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.ContactsInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.ContactsListener;
import xyz.thedevspot.voiperinho.network.ApiManager;

/**
 * Created by foi on 09/01/16.
 */
public class ContactsInteractorImpl implements ContactsInteractor {

    private ContactsListener listener;

    @Override
    public void getContacts(ContactsListener listener) {
        this.listener = listener;
        int id = SharedPreferencesHelper.getUserId(VoiperinhoApplication.getInstance());

        Call<BaseResponse<List<User>>> call = ApiManager.getService().getContacts(id);
        call.enqueue(callback);
    }

    private Callback<BaseResponse<List<User>>> callback = new Callback<BaseResponse<List<User>>>() {
        @Override
        public void onResponse(Response<BaseResponse<List<User>>> response, Retrofit retrofit) {
            listener.onContactsReceived(response.body().getMessage());
        }

        @Override
        public void onFailure(Throwable t) {
            listener.onError();
        }
    };
}
