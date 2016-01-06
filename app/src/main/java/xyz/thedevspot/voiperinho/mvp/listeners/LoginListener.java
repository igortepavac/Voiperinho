package xyz.thedevspot.voiperinho.mvp.listeners;

/**
 * Created by foi on 06/01/16.
 */
public interface LoginListener {

    void onLoginSuccess(String token);

    void onLoginFail(String error);
}
