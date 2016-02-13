package xyz.thedevspot.voiperinho.mvp.interactors;

import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.listeners.Listener;

/**
 * Created by foi on 06/01/16.
 */
public interface RegisterInteractor {

    void attemptRegistration(Listener<Void> listener, RegisterRequest registerRequest);
}
