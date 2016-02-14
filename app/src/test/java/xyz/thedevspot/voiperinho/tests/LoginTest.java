package xyz.thedevspot.voiperinho.tests;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import xyz.thedevspot.voiperinho.BuildConfig;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.VoiperinhoTestApplication;
import xyz.thedevspot.voiperinho.activities.LoginActivity;
import xyz.thedevspot.voiperinho.activities.RegisterActivity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by foi on 14/02/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, application = VoiperinhoTestApplication.class,
        constants = BuildConfig.class)
public class LoginTest {

    @Test
    public void openRegistrationActivity() {
        ActivityController<LoginActivity> loginActivityActivityController = Robolectric.buildActivity(LoginActivity.class);

        // Get the activity
        LoginActivity loginActivity = loginActivityActivityController.create()
                .start()
                .resume()
                .visible()
                .get();

        // Click the register button
        loginActivity.findViewById(R.id.register_button).performClick();

        Intent expectedIntent = new Intent(loginActivity, RegisterActivity.class);

        assertThat(Shadows.shadowOf(loginActivity).getNextStartedActivity(), equalTo(expectedIntent));
    }
}
