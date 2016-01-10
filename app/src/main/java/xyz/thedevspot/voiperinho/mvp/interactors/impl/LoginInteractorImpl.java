package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import xyz.thedevspot.voiperinho.helpers.SocketHelper;
import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;

/**
 * Created by foi on 06/01/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    LoginListener listener;

    @Override
    public void attemptLogin(LoginListener listener, String username, String password) {
        this.listener = listener;

        SocketHelper socketHelper = new SocketHelper(loginResponseListener, username, password);
        Thread t = new Thread(socketHelper);
        t.start();
    }

    public interface LoginResponseListener {

        void onLoginSuccess(int id);

        void onLoginFail();
    }

    private LoginResponseListener loginResponseListener = new LoginResponseListener() {
        @Override
        public void onLoginSuccess(int id) {
            listener.onLoginSuccess();
        }

        @Override
        public void onLoginFail() {
            listener.onLoginFail();
        }
    };
}
