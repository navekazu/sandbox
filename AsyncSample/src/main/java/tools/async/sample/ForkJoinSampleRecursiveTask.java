package tools.async.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveTask;

// Fork/Joinフレームワーク(Java7以降)のサンプル
public class ForkJoinSampleRecursiveTask extends RecursiveTask<Result> {
    Logger logger = LoggerFactory.getLogger(ForkJoinSampleRecursiveTask.class);
    private final int value;

    public ForkJoinSampleRecursiveTask() {
        this.value = 100;
    }

    public ForkJoinSampleRecursiveTask(int value) {
        this.value = value;
    }

    @Override
    protected Result compute() {
        logger.info("Start compute.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("End compute.");
        Result result = new Result();
        result.value = this.value;
        return result;
    }
}
