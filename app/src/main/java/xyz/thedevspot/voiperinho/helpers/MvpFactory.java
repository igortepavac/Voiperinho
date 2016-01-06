package xyz.thedevspot.voiperinho.helpers;

import xyz.thedevspot.voiperinho.mvp.interactors.impl.LoginInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.LoginPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.LoginPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.views.LoginView;

/**
 * Created by foi on 06/01/16.
 */
public class MvpFactory {

    public static LoginPresenter getPresenter(LoginView view) {
        return new LoginPresenterImpl(view, new LoginInteractorImpl());
    }
}
