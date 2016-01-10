package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.mvp.interactors.RequestsInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.ContactsListener;

/**
 * Created by foi on 10/01/16.
 */
public class RequestsInteractorImpl implements RequestsInteractor {

    private ContactsListener listener;

    @Override
    public void getRequests(ContactsListener listener) {
        this.listener = listener;

        // TODO: retrieve id and get requests
    }

    @Override
    public void acceptRequest(boolean accept) {

        // TODO: accept/deny request
    }
}
