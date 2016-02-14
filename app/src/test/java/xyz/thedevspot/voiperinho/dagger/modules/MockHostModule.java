package xyz.thedevspot.voiperinho.dagger.modules;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by foi on 14/02/16.
 */

@Module
public class MockHostModule {

    private MockWebServer mockWebServer;

    public MockHostModule() {
        mockWebServer = new MockWebServer();

        try {
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MockWebServer getMockWebServer() {
        return mockWebServer;
    }

    @Provides
    @Singleton
    public String provideBaseUrl() {
        return mockWebServer.url("/").toString();
    }
}
