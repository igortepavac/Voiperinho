package xyz.thedevspot.voiperinho.activities;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.mvp.views.BaseView;
import xyz.thedevspot.voiperinho.mvp.views.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void onRegisterSuccess() {

    }

    @Override
    public void onRegisterFail() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(@StringRes int error) {

    }
}
