package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import xyz.thedevspot.voiperinho.mvp.interactors.RegisterInteractor;
import xyz.thedevspot.voiperinho.mvp.presenters.RegisterPresenter;
import xyz.thedevspot.voiperinho.mvp.views.RegisterView;

/**
 * Created by foi on 06/01/16.
 */
public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterView view;

    private RegisterInteractor interactor;

    public RegisterPresenterImpl(RegisterView view, RegisterInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void attemptRegistration(String username, String password, String email, String avatar) {

    }
}
