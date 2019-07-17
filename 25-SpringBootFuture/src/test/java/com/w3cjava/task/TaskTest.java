package com.w3cjava.task;


import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.w3cjava.SpringBootAsyncPool;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootAsyncPool.class)
public class TaskTest {
    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {
        Future<String> futureResult = task.run();
        String result = futureResult.get();
        System.out.println(result);
    }
	
}
