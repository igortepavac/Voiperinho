package xyz.thedevspot.voiperinho.mvp.presenters;

import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 09/01/16.
 */
public interface ContactsPresenter {

    void getContacts();

    void onContactClick(User user);
}
