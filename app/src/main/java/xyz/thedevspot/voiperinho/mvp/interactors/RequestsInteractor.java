package xyz.thedevspot.voiperinho.mvp.interactors;

import xyz.thedevspot.voiperinho.mvp.listeners.RequestsListener;

/**
 * Created by foi on 10/01/16.
 */
public interface RequestsInteractor {

    void getRequests(RequestsListener listener);

    void acceptRequest(boolean accept);
}
