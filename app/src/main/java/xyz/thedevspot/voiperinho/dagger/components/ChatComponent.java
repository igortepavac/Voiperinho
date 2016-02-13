package xyz.thedevspot.voiperinho.dagger.components;

import dagger.Component;
import xyz.thedevspot.voiperinho.activities.ChatActivity;
import xyz.thedevspot.voiperinho.dagger.modules.ChatModule;

/**
 * Created by foi on 13/02/16.
 */

@Component(modules = {
        ChatModule.class
})
public interface ChatComponent {

    void inject(ChatActivity activity);
}
