package xyz.thedevspot.voiperinho.dagger.components;

import dagger.Component;
import xyz.thedevspot.voiperinho.dagger.modules.ContactsModule;
import xyz.thedevspot.voiperinho.dagger.modules.NetworkModule;
import xyz.thedevspot.voiperinho.fragments.ContactsFragment;

/**
 * Created by foi on 13/02/16.
 */

@Component(modules = {
        NetworkModule.class,
        ContactsModule.class
})
public interface ContactsComponent {

    void inject(ContactsFragment fragment);
}
