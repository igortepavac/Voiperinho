package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.mvp.interactors.ContactsInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.ContactsListener;

/**
 * Created by foi on 09/01/16.
 */
public class ContactsInteractorImpl implements ContactsInteractor {

    private ContactsListener listener;

    @Override
    public void getContacts(ContactsListener listener) {
        this.listener = listener;

        // TODO: retrieve id and get contacts
    }
}
