package xyz.thedevspot.voiperinho.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.dagger.modules.ApiModule;
import xyz.thedevspot.voiperinho.dagger.modules.ConverterFactoryModule;
import xyz.thedevspot.voiperinho.dagger.modules.HostModule;
import xyz.thedevspot.voiperinho.dagger.modules.HttpClientModule;

/**
 * Created by foi on 13/02/16.
 */

@Component(modules = {
        HostModule.class,
        HttpClientModule.class,
        ConverterFactoryModule.class,
        ApiModule.class
})
@Singleton
public interface ApplicationComponent {

    void inject(VoiperinhoApplication application);
}
