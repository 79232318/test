package com.spring.springboot.观察者;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	ApplicationContext applicationContext;
	
	public void addOrder() {
		System.out.println("1.添加订单");
		
		OrderEvent event = new OrderEvent("参数");
		applicationContext.publishEvent(event);
		System.out.println("完成");
	}
}
