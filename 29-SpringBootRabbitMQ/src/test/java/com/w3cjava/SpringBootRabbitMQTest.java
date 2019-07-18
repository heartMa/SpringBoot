package com.w3cjava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.w3cjava.send.Sender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootRabbitMQ.class)
public class SpringBootRabbitMQTest {
	@Autowired
	private Sender sender;

	@Test
	public void hello() throws Exception {
		sender.send();
	}
}
