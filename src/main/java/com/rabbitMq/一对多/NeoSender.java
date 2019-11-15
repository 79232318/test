package com.rabbitMq.一对多;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeoSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(int i) {
		String context = "rabbitMq一对多"+" ****** "+i;
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("onetomany", context);
	}

}