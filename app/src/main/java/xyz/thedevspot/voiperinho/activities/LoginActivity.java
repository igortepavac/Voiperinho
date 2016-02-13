package xyz.thedevspot.voiperinho.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.dagger.components.DaggerLoginComponent;
import xyz.thedevspot.voiperinho.dagger.modules.LoginModule;
import xyz.thedevspot.voiperinho.mvp.presenters.LoginPresenter;
import xyz.thedevspot.voiperinho.mvp.views.LoginView;

public class LoginActivity extends BaseActivity implements LoginView {

    @Bind(R.id.username)
    EditText username;

    @Bind(R.id.password)
    EditText password;

    @Bind(R.id.login_progress)
    View progressView;

    @Bind(R.id.login_form)
    View loginFormView;

    @Bind(R.id.login_button)
    Button loginButton;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @OnEditorAction(R.id.password)
    protected boolean onActionPassword() {
        attemptLogin();
        return true;
    }

    @OnClick(R.id.login_button)
    protected void onClickLogin() {
        attemptLogin();
    }

    @OnClick(R.id.register_button)
    protected void onClickRegister() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private void attemptLogin() {
        presenter.attemptLogin(username.getText().toString(), password.getText().toString());
    }

    private void showProgress(final boolean show) {
        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onLoginFail() {
        showMessage(R.string.credentials_incorrect);
    }

    @Override
    public void showProgress() {
        showProgress(true);
    }

    @Override
    public void hideProgress() {
        showProgress(false);
    }
}

