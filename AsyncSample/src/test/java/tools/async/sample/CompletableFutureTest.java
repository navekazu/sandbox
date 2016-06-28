package tools.async.sample;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class CompletableFutureTest {
    Logger logger = LoggerFactory.getLogger(CompletableFutureTest.class);

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
    public void completableFutureTest1() {
        logger.info("***** completableFutureTest1 *****");

        // Task1を実行後、Task2とTask3を同時実行し、終了後にTask4を実行
        CompletableFutureSample sample = new CompletableFutureSample();
        CompletableFuture.supplyAsync(() -> sample.task01()).join();
        CompletableFuture.allOf(CompletableFuture.supplyAsync(() -> sample.task02(null)), CompletableFuture.supplyAsync(() -> sample.task03(null))).join();
        CompletableFuture.supplyAsync(() -> sample.task04(null, null)).join();

        logger.info("finish completableFutureTest1.");
    }
}
