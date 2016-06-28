package tools.async.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// CompletableFutureフレームワーク(Java8以降)のサンプル
public class CompletableFutureSample {
    Logger logger = LoggerFactory.getLogger(CompletableFutureSample.class);

    public Result task01() {
        logger.info("Start task01 call.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End task01 call.");
        return new Result(1);
    }

    public Result task02(Result prevResult) {
        logger.info("Start task02 call.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End task02 call.");
        return new Result(2);
    }

    public Result task03(Result prevResult) {
        logger.info("Start task03 call.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End task03 call.");
        return new Result(3);
    }

    public Result task04(Result prevResult1, Result prevResult2) {
        logger.info("Start task04 call.");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End task04 call.");
        return new Result(4);
    }

    public Result task05() {
        logger.info("Start task05 call.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("End task05 call.");
        return new Result(5);
    }
}
