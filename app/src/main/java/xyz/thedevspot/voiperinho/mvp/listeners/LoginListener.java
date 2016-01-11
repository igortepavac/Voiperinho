package xyz.thedevspot.voiperinho.mvp.listeners;

import android.support.annotation.StringRes;

/**
 * Created by foi on 06/01/16.
 */
public interface LoginListener {

    void onLoginSuccess();

    void onLoginFail();

    void onConnectionError(@StringRes int error);
}
