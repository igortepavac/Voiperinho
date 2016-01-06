package xyz.thedevspot.voiperinho.mvp.interactors;

import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;

/**
 * Created by foi on 06/01/16.
 */
public interface LoginInteractor {

    void attemptLogin(LoginListener listener, String username, String password);
}
