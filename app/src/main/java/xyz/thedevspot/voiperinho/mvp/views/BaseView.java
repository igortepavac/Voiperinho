package xyz.thedevspot.voiperinho.mvp.views;

import android.support.annotation.StringRes;

/**
 * Created by foi on 06/01/16.
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showMessage(@StringRes int error);
}
