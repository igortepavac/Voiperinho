package xyz.thedevspot.voiperinho.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.dagger.modules.ApiModule;
import xyz.thedevspot.voiperinho.dagger.modules.BaseUrlModule;

/**
 * Created by foi on 13/02/16.
 */

@Component(modules = {
        BaseUrlModule.class,
        ApiModule.class
})
@Singleton
public interface ApplicationComponent {

    void inject(VoiperinhoApplication application);
}
