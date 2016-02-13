package xyz.thedevspot.voiperinho.dagger.components;

import dagger.Component;
import xyz.thedevspot.voiperinho.activities.LoginActivity;
import xyz.thedevspot.voiperinho.dagger.modules.LoginModule;

/**
 * Created by foi on 13/02/16.
 */

@Component(modules = {
        LoginModule.class
})
public interface LoginComponent {

    void inject(LoginActivity activity);
}
