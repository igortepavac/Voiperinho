package xyz.thedevspot.voiperinho.mvp.presenters;

/**
 * Created by foi on 06/01/16.
 */
public interface RegisterPresenter {

    void attemptRegistration(String username, String password, String email, String avatar);
}
