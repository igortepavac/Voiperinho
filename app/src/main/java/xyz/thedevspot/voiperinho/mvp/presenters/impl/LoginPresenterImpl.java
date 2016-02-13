package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import android.support.annotation.StringRes;
import android.text.TextUtils;

import javax.inject.Inject;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.listeners.LoginListener;
import xyz.thedevspot.voiperinho.mvp.presenters.LoginPresenter;
import xyz.thedevspot.voiperinho.mvp.views.LoginView;

/**
 * Created by foi on 06/01/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;

    private LoginInteractor interactor;

    @Inject
    public LoginPresenterImpl(LoginView view, LoginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void attemptLogin(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            view.showMessage(R.string.credentials_empty);
        } else {
            view.showProgress();
            interactor.attemptLogin(loginListener, username, password);
        }

    }

    private LoginListener loginListener = new LoginListener() {
        @Override
        public void onSuccess(Void v) {
            view.hideProgress();
            view.onLoginSuccess();
        }

        @Override
        public void onFailure() {
            view.hideProgress();
            view.onLoginFail();
        }

        @Override
        public void onConnectionError(@StringRes int error) {
            view.hideProgress();
            view.showMessage(error);
        }
    };
}
