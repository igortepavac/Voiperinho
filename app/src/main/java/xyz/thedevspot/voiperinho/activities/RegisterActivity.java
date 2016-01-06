package xyz.thedevspot.voiperinho.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.helpers.MvpFactory;
import xyz.thedevspot.voiperinho.mvp.presenters.RegisterPresenter;
import xyz.thedevspot.voiperinho.mvp.views.BaseView;
import xyz.thedevspot.voiperinho.mvp.views.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView {

    @Bind(R.id.register_form)
    View registerFormView;

    @Bind(R.id.register_progress)
    View progressView;

    @Bind(R.id.register_username)
    EditText registrationUsername;

    @Bind(R.id.register_password)
    EditText registrationPassword;

    @Bind(R.id.register_email)
    EditText registrationEmail;

    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
        presenter = MvpFactory.getPresenter(this);
    }

    @OnClick(R.id.register_user_button)
    protected void onClickRegister() {
        presenter.attemptRegistration(registrationUsername.getText().toString(),
                registrationPassword.getText().toString(),
                registrationEmail.getText().toString(),
                null);
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            registerFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            registerFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    registerFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            registerFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void onRegisterSuccess() {
        showSuccessDialog();
    }

    @Override
    public void onRegisterFail() {
        showError(R.string.something_wrong);
    }

    @Override
    public void showProgress() {
        showProgress(true);
    }

    @Override
    public void hideProgress() {
        showProgress(false);
    }

    @Override
    public void showError(@StringRes int error) {
        showErrorMessage(getString(error));
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.registration_success_title))
                .setMessage(getString(R.string.registration_success_message))
                .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendResult();
                    }
                })
                .show();
    }

    void sendResult() {
        setResult(RESULT_OK);
        finish();
    }
}
