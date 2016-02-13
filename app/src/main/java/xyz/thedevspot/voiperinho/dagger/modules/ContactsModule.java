package xyz.thedevspot.voiperinho.dagger.modules;

import dagger.Module;
import dagger.Provides;
import xyz.thedevspot.voiperinho.mvp.interactors.ContactsInteractor;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.ContactsInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.ContactsPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.ContactsPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.views.ContactsView;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class ContactsModule {

    private ContactsView contactsView;

    public ContactsModule(ContactsView contactsView) {
        this.contactsView = contactsView;
    }

    @Provides
    public ContactsView providesContactsView() {
        return contactsView;
    }

    @Provides
    public ContactsPresenter providesContactsPresenter(ContactsPresenterImpl contactsPresenter) {
        return contactsPresenter;
    }

    @Provides
    public ContactsInteractor providesContactsInteractor(ContactsInteractorImpl contactsInteractor) {
        return contactsInteractor;
    }
}
