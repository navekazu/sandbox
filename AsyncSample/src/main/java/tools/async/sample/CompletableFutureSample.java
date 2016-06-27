package tools.async.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// CompletableFutureフレームワーク(Java8以降)のサンプル
public class CompletableFutureSample {
    Logger logger = LoggerFactory.getLogger(CompletableFutureSample.class);

    public Result exec1() {
        logger.info("Start exec1 call.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End exec1 call.");
        return new Result(1);
    }

    public Result exec10() {
        logger.info("Start exec10 call.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End exec10 call.");
        return new Result(10);
    }

    public Result exec100() {
        logger.info("Start exec100 call.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End exec100 call.");
        return new Result(100);
    }
}
