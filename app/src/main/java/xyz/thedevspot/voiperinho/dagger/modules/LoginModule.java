package xyz.thedevspot.voiperinho.dagger.modules;

import dagger.Module;
import dagger.Provides;
import xyz.thedevspot.voiperinho.mvp.interactors.LoginInteractor;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.LoginInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.LoginPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.LoginPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.views.LoginView;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class LoginModule {

    private LoginView loginView;

    public LoginModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    public LoginView provideLoginView() {
        return loginView;
    }

    @Provides
    public LoginPresenter provideLoginPresenter(LoginPresenterImpl loginPresenter) {
        return loginPresenter;
    }

    @Provides
    public LoginInteractor provideLoginInteractor(LoginInteractorImpl loginInteractor) {
        return loginInteractor;
    }
}
