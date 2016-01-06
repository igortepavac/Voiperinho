package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;

/**
 * Created by foi on 06/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener loginListener;

    @Override
    public void attemptLogin(LoginListener listener, String username, String password) {
        this.loginListener = listener;
        //LoginRequest loginRequest = new LoginRequest(username, password);
        //ApiManager.getService().userLogin(loginRequest, loginResponseCallback);
    }

    // TODO: Create callback
}
