package com.ztj.springbootdemo.task;

import com.ztj.springbootdemo.event.ApplicationFailedEventListener;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Slf4j
@Component
public class AsyncTasks {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTasks.class.getName());

    // @Async method can not be static, or @Async won't work
    // Future<T> is used to get callback results
    @Async("taskExecutor")
    public Future<String> doTaskOne() throws Exception {
        logger.info("task 1 start");
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        logger.info("task 1 finished: " + (end - start) + " ms");
        return new AsyncResult<>("task 1 finished");
    }

    @Async("taskExecutor")
    public Future<String> doTaskTwo() throws Exception {
        logger.info("task 2 start");
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        logger.info("task 2 finished: " + (end - start) + " ms");
        return new AsyncResult<>("task 1 finished");
    }

    @Async("taskExecutor")
    public Future<String> doTaskThree() throws Exception {
        logger.info("task 3 start");
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        logger.info("task 3 finished: " + (end - start) + " ms");
        return new AsyncResult<>("task 3 finished");
    }

}
