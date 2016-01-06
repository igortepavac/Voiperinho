package xyz.thedevspot.voiperinho.mvp.listeners;

import xyz.thedevspot.voiperinho.models.LoginResponse;

/**
 * Created by foi on 06/01/16.
 */
public interface LoginListener {

    void onLoginSuccess();

    void onLoginFail();
}
