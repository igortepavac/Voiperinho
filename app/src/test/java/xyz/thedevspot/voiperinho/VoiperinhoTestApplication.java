package xyz.thedevspot.voiperinho;

import android.annotation.SuppressLint;

import org.robolectric.TestLifecycleApplication;

import java.io.IOException;
import java.lang.reflect.Method;

import okhttp3.mockwebserver.MockWebServer;
import xyz.thedevspot.voiperinho.dagger.components.DaggerTestApplicationComponent;
import xyz.thedevspot.voiperinho.dagger.modules.MockHostModule;

/**
 * Created by foi on 14/02/16.
 */
public class VoiperinhoTestApplication extends VoiperinhoApplication implements TestLifecycleApplication {

    private static MockWebServer mockWebServer;

    public static MockWebServer getMockWebServer() {
        return mockWebServer;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate() {
        instance = this;
    }

    @Override
    public void beforeTest(Method method) {
        MockHostModule mockHostModule = new MockHostModule();
        mockWebServer = mockHostModule.getMockWebServer();

        DaggerTestApplicationComponent.builder()
                .mockHostModule(mockHostModule)
                .build()
                .inject(this);
    }

    @Override
    public void prepareTest(Object test) {

    }

    @Override
    public void afterTest(Method method) {
        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
