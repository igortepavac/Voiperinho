package xyz.thedevspot.voiperinho.mvp.listeners;

import java.util.List;

import xyz.thedevspot.voiperinho.models.User;

/**
 * Created by foi on 09/01/16.
 */
public interface ContactsListener {

    void onContactsReceived(List<User> contactList);

    void onError();
}
