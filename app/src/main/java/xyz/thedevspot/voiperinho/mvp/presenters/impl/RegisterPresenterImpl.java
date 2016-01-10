package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import android.text.TextUtils;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.models.RegisterRequest;
import xyz.thedevspot.voiperinho.mvp.interactors.RegisterInteractor;
import xyz.thedevspot.voiperinho.mvp.listeners.RegisterListener;
import xyz.thedevspot.voiperinho.mvp.presenters.RegisterPresenter;
import xyz.thedevspot.voiperinho.mvp.views.RegisterView;

/**
 * Created by foi on 06/01/16.
 */
public class RegisterPresenterImpl implements RegisterPresenter {

    private static final int PASSWORD_LENGTH = 6;

    private static final String MAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    private RegisterView view;

    private RegisterInteractor interactor;

    public RegisterPresenterImpl(RegisterView view, RegisterInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void attemptRegistration(String username, String password, String email, String avatar) {
        if (isDataValid(username, password, email)) {
            RegisterRequest request = new RegisterRequest(username, password, email, avatar);

            view.showProgress();
            interactor.attemptRegistration(listener, request);
        }
    }

    private RegisterListener listener = new RegisterListener() {
        @Override
        public void onRegisterSuccess() {
            view.hideProgress();
            view.onRegisterSuccess();
        }

        @Override
        public void onRegisterFail() {
            view.hideProgress();
            view.onRegisterFail();
        }
    };

    private boolean isDataValid(String username, String password, String email) {
        boolean ret = false;

        if (!isFormFilled(username, password, email)) {
            view.showMessage(R.string.credentials_empty);
        } else if (!isMailValid(email)) {
            view.showMessage(R.string.registration_mail_not_valid);
        } else if (!isPasswordValid(password)) {
            view.showMessage(R.string.registration_password_not_valid);
        } else {
            ret = true;
        }

        return ret;
    }

    private boolean isFormFilled(String username, String password, String email) {
        return !(TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(email));
    }

    private boolean isMailValid(String mail) {
        return mail.matches(MAIL_REGEX);
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= PASSWORD_LENGTH;
    }
}
