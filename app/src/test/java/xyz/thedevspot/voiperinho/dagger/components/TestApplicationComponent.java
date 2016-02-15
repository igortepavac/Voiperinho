package xyz.thedevspot.voiperinho.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.dagger.modules.ConverterFactoryModule;
import xyz.thedevspot.voiperinho.dagger.modules.MockApiModule;
import xyz.thedevspot.voiperinho.dagger.modules.MockHostModule;
import xyz.thedevspot.voiperinho.dagger.modules.MockHttpClientModule;
import xyz.thedevspot.voiperinho.dagger.modules.SingleThreadExecutorModule;

/**
 * Created by foi on 14/02/16.
 */

@Component(modules = {
        MockHostModule.class,
        SingleThreadExecutorModule.class,
        ConverterFactoryModule.class,
        MockHttpClientModule.class,
        MockApiModule.class
})
@Singleton
public interface TestApplicationComponent {

    void inject(VoiperinhoApplication application);
}
