package xyz.thedevspot.voiperinho.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.helpers.MvpFactory;
import xyz.thedevspot.voiperinho.mvp.presenters.RegisterPresenter;
import xyz.thedevspot.voiperinho.mvp.views.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView {

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

    @Override
    public void onRegisterSuccess() {
        showSuccessDialog();
    }

    @Override
    public void onRegisterFail() {
        showMessage(R.string.something_wrong);
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.registration_success_title))
                .setMessage(getString(R.string.registration_success_message))
                .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }
}
