package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import java.util.ArrayList;
import java.util.List;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.ContactsInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.ContactsListener;
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
        //view.showProgress();
        //interactor.getContacts(listener);
        List<User> contacts = new ArrayList<>();

        User user = new User();
        user.setUsername("Jovan");
        contacts.add(user);

        user = new User();
        user.setUsername("Nino");
        contacts.add(user);

        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nino");
        contacts.add(user);
        user = new User();
        user.setUsername("Nora");
        contacts.add(user);
        user = new User();
        user.setUsername("Zoki");
        contacts.add(user);
        user = new User();
        user.setUsername("Stevo");
        contacts.add(user);


        view.onContactsReceived(contacts);
    }

    @Override
    public void onContactClick(int id) {

        // TODO: save id with different tagg

    }

    private ContactsListener listener = new ContactsListener() {
        @Override
        public void onContactsReceived(List<User> contactList) {
            view.hideProgress();

            if (contactList != null && contactList.size() > 0) {
                view.onContactsReceived(contactList);
            } else {
                view.onContatcsEmpty();
            }
        }

        @Override
        public void onError() {
            view.hideProgress();
            view.showMessage(R.string.something_wrong);
        }
    };
}
