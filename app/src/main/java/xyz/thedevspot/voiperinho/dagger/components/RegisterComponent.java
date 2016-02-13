package xyz.thedevspot.voiperinho.dagger.components;

import dagger.Component;
import xyz.thedevspot.voiperinho.activities.RegisterActivity;
import xyz.thedevspot.voiperinho.dagger.modules.NetworkModule;
import xyz.thedevspot.voiperinho.dagger.modules.RegisterModule;

/**
 * Created by foi on 13/02/16.
 */

@Component(modules = {
        NetworkModule.class,
        RegisterModule.class
})
public interface RegisterComponent {

    void inject(RegisterActivity activity);
}
