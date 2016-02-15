package xyz.thedevspot.voiperinho.dagger.modules;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import dagger.Module;
import dagger.Provides;
import xyz.thedevspot.voiperinho.helpers.SingleThreadExecutor;
import xyz.thedevspot.voiperinho.helpers.SingleThreadExecutorService;

/**
 * Created by foi on 14/02/16.
 */

@Module
public class SingleThreadExecutorModule {

    @Provides
    public Executor provideCallbackExecutor() {
        return new SingleThreadExecutor();
    }

    @Provides
    public ExecutorService provideExecutorService() {
        return new SingleThreadExecutorService();
    }
}
