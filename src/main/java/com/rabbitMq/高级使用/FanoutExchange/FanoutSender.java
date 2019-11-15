package com.rabbitMq.高级使用.FanoutExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, fanout msg ";
		System.out.println("Sender : " + context);
		//配置了 routing_key 会被忽略。
		this.rabbitTemplate.convertAndSend("fanoutExchange","fanout.D", context);
	}

}