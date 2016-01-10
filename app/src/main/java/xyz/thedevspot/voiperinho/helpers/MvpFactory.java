package xyz.thedevspot.voiperinho.helpers;

import xyz.thedevspot.voiperinho.mvp.interactors.impl.ContactsInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.LoginInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.RegisterInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.RequestsInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.ContactsPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.LoginPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.RegisterPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.RequestsPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.ContactsPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.LoginPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.RegisterPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.RequestsPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.views.ContactsView;
import xyz.thedevspot.voiperinho.mvp.views.LoginView;
import xyz.thedevspot.voiperinho.mvp.views.RegisterView;
import xyz.thedevspot.voiperinho.mvp.views.RequestsView;

/**
 * Created by foi on 06/01/16.
 */
public class MvpFactory {

    public static LoginPresenter getPresenter(LoginView view) {
        return new LoginPresenterImpl(view, new LoginInteractorImpl());
    }

    public static RegisterPresenter getPresenter(RegisterView view) {
        return new RegisterPresenterImpl(view, new RegisterInteractorImpl());
    }

    public static ContactsPresenter getPresenter(ContactsView view) {
        return new ContactsPresenterImpl(view, new ContactsInteractorImpl());
    }

    public static RequestsPresenter getPresenter(RequestsView view) {
        return new RequestsPresenterImpl(view, new RequestsInteractorImpl());
    }
}
