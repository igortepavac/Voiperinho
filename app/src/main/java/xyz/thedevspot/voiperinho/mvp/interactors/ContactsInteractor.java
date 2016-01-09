package xyz.thedevspot.voiperinho.mvp.interactors;

import xyz.thedevspot.voiperinho.mvp.listeners.ContactsListener;

/**
 * Created by foi on 09/01/16.
 */
public interface ContactsInteractor {

    void getContacts(ContactsListener listener);
}
