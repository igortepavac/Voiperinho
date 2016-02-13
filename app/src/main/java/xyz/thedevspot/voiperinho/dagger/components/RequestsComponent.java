package xyz.thedevspot.voiperinho.dagger.components;

import dagger.Component;
import xyz.thedevspot.voiperinho.dagger.modules.NetworkModule;
import xyz.thedevspot.voiperinho.dagger.modules.RequestsModule;
import xyz.thedevspot.voiperinho.fragments.RequestsFragment;

/**
 * Created by foi on 13/02/16.
 */

@Component(modules = {
        NetworkModule.class,
        RequestsModule.class
})
public interface RequestsComponent {

    void inject(RequestsFragment fragment);
}
