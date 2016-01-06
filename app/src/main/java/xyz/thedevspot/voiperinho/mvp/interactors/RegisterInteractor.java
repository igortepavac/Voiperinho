package xyz.thedevspot.voiperinho.mvp.interactors;

import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.listeners.RegisterListener;

/**
 * Created by foi on 06/01/16.
 */
public interface RegisterInteractor {

    void attemptRegistration(RegisterListener listener, RegisterRequest registerRequest);
}
