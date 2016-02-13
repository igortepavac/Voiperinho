package xyz.thedevspot.voiperinho.dagger.modules;

import dagger.Module;
import dagger.Provides;
import xyz.thedevspot.voiperinho.mvp.interactors.ChatInteractor;
import xyz.thedevspot.voiperinho.mvp.interactors.impl.ChatInteractorImpl;
import xyz.thedevspot.voiperinho.mvp.presenters.ChatPresenter;
import xyz.thedevspot.voiperinho.mvp.presenters.impl.ChatPresenterImpl;
import xyz.thedevspot.voiperinho.mvp.views.ChatView;

/**
 * Created by foi on 13/02/16.
 */

@Module
public class ChatModule {

    private ChatView chatView;

    public ChatModule(ChatView chatView) {
        this.chatView = chatView;
    }

    @Provides
    public ChatView provideChatView() {
        return chatView;
    }

    @Provides
    public ChatPresenter provideChatPresenter(ChatPresenterImpl chatPresenter) {
        return chatPresenter;
    }

    @Provides
    public ChatInteractor provideChatInteractor(ChatInteractorImpl chatInteractor) {
        return chatInteractor;
    }
}
