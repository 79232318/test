package com.rabbitMq.多对多;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManySender2 {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String name, int i) {
		String context = "多对多，我是"+name+"发送者,这是第"+i+"调信息";
		System.out.println("Sender2 : " + context);
		this.rabbitTemplate.convertAndSend("manytomany", context);
	}

}