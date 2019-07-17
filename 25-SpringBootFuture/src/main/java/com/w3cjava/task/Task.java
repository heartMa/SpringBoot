package com.w3cjava.task;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class Task {

	  public static Random random = new Random();

	    @Async("taskExecutor")
	    public Future<String> run() throws Exception {
	        long sleep = random.nextInt(10000);
	        System.out.println("开始任务，需耗时：" + sleep + "毫秒");
	        Thread.sleep(sleep);
	        System.out.println("完成任务");
	        return new AsyncResult<>("test");
	    }
}
