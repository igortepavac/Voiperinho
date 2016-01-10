package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import android.text.TextUtils;

import xyz.thedevspot.voiperinho.R;
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
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.showMessage(R.string.credentials_empty);
        } else {
            loginView.showProgress();
            loginInteractor.attemptLogin(loginListener, username, password);
        }

    }

    private LoginListener loginListener = new LoginListener() {
        @Override
        public void onLoginSuccess() {
            loginView.hideProgress();
            loginView.onLoginSuccess();
        }

        @Override
        public void onLoginFail() {
            loginView.hideProgress();
            loginView.onLoginFail();
        }
    };
}
