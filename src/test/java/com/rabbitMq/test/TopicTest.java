package com.rabbitMq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitMq.高级使用.TopicExchange.TopicSender;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

	@Autowired
	private TopicSender sender;
     /**
      * 发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，
      */
	@Test
	public void topic1() throws Exception {
		sender.send1();
	}
	/**
     * 发送send2只有topic.messages可以匹配所以只有Receiver2监听到消息
     */
	@Test
	public void topic2() throws Exception {
		sender.send2();
	}
	/**
     *  
     */
	@Test
	public void topic3() throws Exception {
			
			sender.send3();
	}
	
	@Test
	public void topic4() throws Exception {
			
			sender.send4();
	}

}