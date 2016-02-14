package xyz.thedevspot.voiperinho.helpers;

import java.util.concurrent.Executor;

/**
 * Created by foi on 14/02/16.
 */

public class SingleThreadExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
