package xyz.thedevspot.voiperinho.dagger.modules;

import dagger.Module;
import dagger.Provides;
import xyz.thedevspot.voiperinho.mvp.interactors.RegisterInteractor;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.RegisterInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.RegisterPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.RegisterPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.views.RegisterView;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class RegisterModule {

    private RegisterView registerView;

    public RegisterModule(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Provides
    public RegisterView provideRegisterView() {
        return registerView;
    }

    @Provides
    public RegisterPresenter provideRegisterPresenter(RegisterPresenterImpl registerPresenter) {
        return registerPresenter;
    }

    @Provides
    public RegisterInteractor provideRegisterInteractor(RegisterInteractorImpl registerInteractor) {
        return registerInteractor;
    }
}
