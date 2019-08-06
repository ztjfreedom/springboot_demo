package com.ztj.springbootdemo.task;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTasksTest {

    @Resource
    private AsyncTasks asyncTasks;

    @Test
    public void testAsyncTasks() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTasks.doTaskOne();
        Future<String> task2 = asyncTasks.doTaskTwo();
        Future<String> task3 = asyncTasks.doTaskThree();
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) Thread.sleep(200);
        long end = System.currentTimeMillis();
        System.out.println("All tasks finished, totally: " + (end - start) + " ms");

        String result = task1.get(5, TimeUnit.SECONDS);
        System.out.println(result);
        Assert.assertEquals("task 1 finished", result);
    }

}
