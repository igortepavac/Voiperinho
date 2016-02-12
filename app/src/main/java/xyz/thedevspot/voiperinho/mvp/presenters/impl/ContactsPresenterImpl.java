package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import java.util.List;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.ContactsInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.Listener;
import xyz.thedevspot.voiperinho.mvp.presenters.ContactsPresenter;
import xyz.thedevspot.voiperinho.mvp.views.ContactsView;

/**
 * Created by foi on 09/01/16.
 */
public class ContactsPresenterImpl implements ContactsPresenter {

    private ContactsView view;

    private ContactsInteractor interactor;

    public ContactsPresenterImpl(ContactsView view, ContactsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void getContacts() {
        view.showProgress();
        interactor.getContacts(listener);
    }

    @Override
    public void onContactClick(User user) {
        SharedPreferencesHelper.setInt(user.getId(), SharedPreferencesHelper.CONTACT_ID);
        SharedPreferencesHelper.setString(user.getUsername(), SharedPreferencesHelper.CONTACT);
    }

    private Listener<List<User>> listener = new Listener<List<User>>() {
        @Override
        public void onSuccess(List<User> contactList) {
            view.hideProgress();

            if (contactList != null && contactList.size() > 0) {
                view.onContactsReceived(contactList);
            } else {
                view.onContatcsEmpty();
            }
        }

        @Override
        public void onFailure() {
            view.hideProgress();
            view.showMessage(R.string.something_wrong);
        }
    };
}
