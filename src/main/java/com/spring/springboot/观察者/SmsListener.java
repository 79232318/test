package com.spring.springboot.观察者;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class SmsListener implements ApplicationListener<OrderEvent> {

	
	@Override
	public void onApplicationEvent(OrderEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getSource());
		sendMsg();
	}

	public void sendMsg() {
		System.out.println("2.发送短信验证");
	}
}
