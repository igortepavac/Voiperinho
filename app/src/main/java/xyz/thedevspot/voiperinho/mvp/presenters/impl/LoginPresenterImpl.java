package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.LoginListener;
import xyz.thedevspot.voiperinho.mvp.presenters.LoginPresenter;
import xyz.thedevspot.voiperinho.mvp.views.LoginView;

/**
 * Created by foi on 06/01/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void attemptLogin(String username, String password) {

    }

    private LoginListener loginListener = new LoginListener() {
        @Override
        public void onLoginSuccess(String token) {

        }

        @Override
        public void onLoginFail(String error) {

        }
    };
}
