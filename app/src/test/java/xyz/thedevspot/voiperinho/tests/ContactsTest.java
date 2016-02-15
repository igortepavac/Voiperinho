package xyz.thedevspot.voiperinho.tests;

import android.widget.ListView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowListView;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import java.net.HttpURLConnection;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import xyz.thedevspot.voiperinho.BuildConfig;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.VoiperinhoTestApplication;
import xyz.thedevspot.voiperinho.adapters.ContactsAdapter;
import xyz.thedevspot.voiperinho.fragments.ContactsFragment;
import xyz.thedevspot.voiperinho.helpers.ResourceUtils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by foi on 14/02/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, application = VoiperinhoTestApplication.class,
        constants = BuildConfig.class)
public class ContactsTest {

    private static final String FILE_NAME = "contacts.json";

    @Test
    public void contactsFetchSuccessful() throws InterruptedException {
        final ContactsFragment contactsFragment = new ContactsFragment();

        // Create and enqueue a mock response
        MockResponse mockResponse = new MockResponse();
        mockResponse.setBody(ResourceUtils.readFromFile(FILE_NAME)).setResponseCode(HttpURLConnection.HTTP_OK);
        VoiperinhoTestApplication.getMockWebServer().enqueue(mockResponse);

        // Start the fragment
        SupportFragmentTestUtil.startFragment(contactsFragment);

        // Check if the list exists
        ListView contactsList = (ListView) contactsFragment.getView().findViewById(R.id.contact_list);
        assertThat(contactsList, is(notNullValue()));

        // Take the request
        RecordedRequest recordedRequest = VoiperinhoTestApplication.getMockWebServer().takeRequest();

        // Populate the list view
        ShadowListView shadowListView = Shadows.shadowOf(contactsList);
        shadowListView.populateItems();

        TextView placeholder = (TextView) contactsFragment.getView().findViewById(R.id.no_contacts);
        assertThat(placeholder.getVisibility(), equalTo(TextView.GONE));

        // Check if the first username is 'Mirko'
        ContactsAdapter adapter = (ContactsAdapter) contactsList.getAdapter();
        assertThat(adapter.getItem(0).getUsername(), equalTo("Mirko"));
    }
}
