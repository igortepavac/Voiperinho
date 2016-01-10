package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import java.util.List;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.RequestsInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.ContactsListener;
import xyz.thedevspot.voiperinho.mvp.presenters.RequestsPresenter;
import xyz.thedevspot.voiperinho.mvp.views.RequestsView;

/**
 * Created by foi on 10/01/16.
 */
public class RequestsPresenterImpl implements RequestsPresenter {

    private RequestsView view;

    private RequestsInteractor interactor;

    public RequestsPresenterImpl(RequestsView view, RequestsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void getRequests() {
        //view.showProgress();
        //interactor.getRequests(listener);
        view.onRequestsEmpty();
    }

    @Override
    public void onRequestClick(boolean accept) {
        //view.showProgress();
        // TODO: accept/deny the request

    }

    private ContactsListener listener = new ContactsListener() {
        @Override
        public void onContactsReceived(List<User> contactList) {
            view.hideProgress();

            if (contactList != null && contactList.size() > 0) {
                view.onRequestsReceived(contactList);
            } else {
                view.onRequestsEmpty();
            }
        }

        @Override
        public void onError() {
            view.hideProgress();
            view.showMessage(R.string.something_wrong);
        }
    };
}
