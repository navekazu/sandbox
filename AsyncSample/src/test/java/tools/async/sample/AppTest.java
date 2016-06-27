package tools.async.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Logger logger = LoggerFactory.getLogger(AppTest.class);

    @BeforeClass
    public static void beforeClass() throws Exception {
    }

    @AfterClass
    public static void afterClass() throws Exception {
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void forkJoinSampleTest1() {
        logger.info("***** forkJoinSampleTest1 *****");

        ForkJoinSampleRecursiveTask sample = new ForkJoinSampleRecursiveTask();

        // forkでRecursiveTaskのcomputeを非同期実行
        logger.info("call fork.");
        sample.fork();

        logger.info("call join.");
        Result result = sample.join();

        logger.info("finish forkJoinSampleTest. value="+result.value);
    }

    @Test
    public void forkJoinSampleTest2() {
        logger.info("***** forkJoinSampleTest2 *****");

        ForkJoinPool pool = new ForkJoinPool();
        Result result;

        // プールに入れて実行(非同期実行を行なう。処理結果は受け取らない)
        pool.execute(new ForkJoinSampleRecursiveTask());
        logger.info("finish forkJoinSampleTest.");

        // プールに入れて実行(処理が終るまで待ち、処理結果を受け取る)
        result = pool.invoke(new ForkJoinSampleRecursiveTask());
        logger.info("finish forkJoinSampleTest. value="+result.value);

        // プールに入れて実行(非同期実行を行ない、処理結果はタスクから受け取る)
//        result = pool.submit .submit(new ForkJoinSample());
//        logger.info("finish forkJoinSampleTest. value="+result.value);
    }

    @Test
    public void forkJoinSampleTest3() {
        logger.info("***** forkJoinSampleTest3 *****");
        ForkJoinPool pool = new ForkJoinPool();
        Result result;

        List<ForkJoinSampleCallable> list = new ArrayList<>();;
        list.add(new ForkJoinSampleCallable(1));
        list.add(new ForkJoinSampleCallable(2));
        list.add(new ForkJoinSampleCallable(3));
        List<Future<Result>> fList = pool.invokeAll(list);

        for (Future<Result> f: fList) {
            try {
                Result r = f.get();
                logger.info("finish forkJoinSampleTest. value=" + (r.value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void completableFutureSampleTest1() {
        logger.info("***** completableFutureSampleTest1 *****");
        CompletableFutureSample sample = new CompletableFutureSample();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<Result> exec1 = CompletableFuture.supplyAsync(() -> sample.exec1(), executor);
        CompletableFuture<Result> exec10 = CompletableFuture.supplyAsync(() -> sample.exec10(), executor);
        CompletableFuture<Result> exec100 = CompletableFuture.supplyAsync(() -> sample.exec100(), executor);

        try {
            logger.info("finish forkJoinSampleTest. value=" + (exec1.get().value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void completableFutureSampleTest2() {
        logger.info("***** completableFutureSampleTest2 *****");
        CompletableFutureSample sample = new CompletableFutureSample();

        CompletableFuture<Result> exec1 = CompletableFuture.supplyAsync(() -> sample.exec1());
        CompletableFuture<Result> exec10 = CompletableFuture.supplyAsync(() -> sample.exec10());
        CompletableFuture<Void> exec100 = exec1.acceptEither(exec10, x -> sample.exec100());

        try {
            logger.info("finish forkJoinSampleTest. value=" + (exec1.get().value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void completableFutureSampleTest3() {
        logger.info("***** completableFutureSampleTest3 *****");
        CompletableFutureSample sample = new CompletableFutureSample();

        CompletableFuture<Result> exec1 = CompletableFuture.supplyAsync(() -> sample.exec1());
        CompletableFuture<Result> exec10 = CompletableFuture.supplyAsync(() -> sample.exec10());
        CompletableFuture<Result> exec100 = CompletableFuture.supplyAsync(() -> sample.exec100());

        try {
            logger.info("finish forkJoinSampleTest?");
            logger.info("finish forkJoinSampleTest. value=" + (exec1.get().value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
