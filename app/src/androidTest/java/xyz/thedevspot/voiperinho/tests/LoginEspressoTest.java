package xyz.thedevspot.voiperinho.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.activities.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by foi on 15/02/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginEspressoTest {

    private static final String USERNAME = "test";

    private static final String PASSWORD = "test";

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void successfulLoginTest() {
        // Enter credentials
        onView(withId(R.id.username)).perform(typeText(USERNAME));
        onView(withId(R.id.password)).perform(typeText(PASSWORD), closeSoftKeyboard());

        // Sign in
        onView(withId(R.id.login_button)).perform(click());

        // New activity should be visible
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
    }

}
