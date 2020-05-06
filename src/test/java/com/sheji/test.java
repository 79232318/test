package com.sheji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bingfa.Service;
import com.bingfa.demo;
import com.spring.springboot.决策者.MyScaleService;
import com.spring.springboot.决策者.UserType;
import com.spring.springboot.观察者.MyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
	@Autowired
    private MyService myService;
     
	@Test
	public void contextLoads() {
		myService.addOrder();
	}
	@Autowired
	private MyScaleService myScaleService;
	 
	@Test
	public void test2() {

		System.out.println(myScaleService.get2(UserType.NORMAL, 100));
	}
}
