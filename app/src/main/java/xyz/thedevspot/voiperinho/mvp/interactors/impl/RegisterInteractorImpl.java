package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.mvp.interactors.RegisterInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.RegisterListener;

/**
 * Created by foi on 06/01/16.
 */
public class RegisterInteractorImpl implements RegisterInteractor {

    private RegisterListener listener;

    @Override
    public void attemptRegistration(RegisterListener listener, RegisterRequest registerRequest) {
        this.listener = listener;

    }
}
