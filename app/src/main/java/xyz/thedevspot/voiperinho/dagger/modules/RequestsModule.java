package xyz.thedevspot.voiperinho.dagger.modules;

import dagger.Module;
import dagger.Provides;
import xyz.thedevspot.voiperinho.mvp.interactors.RequestsInteractor;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.RequestsInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.RequestsPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.RequestsPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.views.RequestsView;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class RequestsModule {

    private RequestsView requestsView;

    public RequestsModule(RequestsView requestsView) {
        this.requestsView = requestsView;
    }

    @Provides
    public RequestsView provideRequestsView() {
        return requestsView;
    }

    @Provides
    public RequestsPresenter provideRequestsPresenter(RequestsPresenterImpl requestsPresenter) {
        return requestsPresenter;
    }

    @Provides
    public RequestsInteractor provideRequestsInteractor(RequestsInteractorImpl requestsInteractor) {
        return requestsInteractor;
    }
}
