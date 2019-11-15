package com.rabbitMq.高级使用.TopicExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TopicSender {
    /**
     * 发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，
     * 发送send2只有topic.messages可以匹配所以只有Receiver2监听到消息
     * 发送send3只有topic.messages可以匹配所以只有Receiver2监听到消息
     */
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send1() {
		String context = "hi, i am message 1";
	    System.out.println("Sender : " + context);
	   // 第一个参数表示交换机，第二个参数表示 routing key，第三个参数即消息。如下：
	    this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
	}

	public void send2() {
		String context = "hi, i am messages 2";
	    System.out.println("Sender : " + context);
	    //第一个参数表示交换机，第二个参数表示 routing key，第三个参数即消息。如下：
	    this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
	}

	public void send3() {
		String context = "hi, i am messages 3 topic.1";
		System.out.println("Sender : " + context);
		//第一个参数表示交换机，第二个参数表示 routing key，第三个参数即消息。如下：
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
	}

	public void send4() {
		String context = "hi, i am messages 4 topic.messages1.b";
		System.out.println("Sender : " + context);
		//第一个参数表示交换机，第二个参数表示 routing key，第三个参数即消息。如下：
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages1.b", context);
	}
}