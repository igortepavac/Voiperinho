package xyz.thedevspot.voiperinho.listeners;

import android.support.annotation.StringRes;

/**
 * Created by foi on 06/01/16.
 */
public interface LoginListener extends Listener<Void> {

    void onConnectionError(@StringRes int error);
}
