package tools.async.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

// Fork/Joinフレームワーク(Java7以降)のサンプル
public class ForkJoinSampleCallable implements Callable<Result> {
    Logger logger = LoggerFactory.getLogger(ForkJoinSampleCallable.class);
    private final int value;

    public ForkJoinSampleCallable() {
        this.value = 100;
    }

    public ForkJoinSampleCallable(int value) {
        this.value = value;
    }

    @Override
    public Result call() throws Exception {
        logger.info("Start call.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("End call.");

        Result result = new Result();
        result.value = this.value;
        return result;
    }
}
