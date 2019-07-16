package com.w3cjava.task;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.w3cjava.SpringBootAsync;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootAsync.class)
public class TaskTest {
	@Autowired
	private Task task;

	@Test
	public void test() throws Exception {
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();
	}
	
	
	@Test
	public void testAsync() throws Exception {
		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTaskOneTest();
		Future<String> task2 = task.doTaskTwoTest();
		Future<String> task3 = task.doTaskThreeTest();

		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}
}
