package com.并发测试;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bingfa.Service;
import com.bingfa.demo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
	@Autowired
    private Service service;

     
	@Test
	public void contextLoads() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				 
					service.update1();
				 
				
			}
		}).start();
        new Thread(new Runnable() {
			
			@Override
			public void run() {
					service.update2();
				
			}
		}).start();
	}
	@Test
	public void contextLoads1() {
		   System.out.println("kaishi");
						service.insert(new demo());
						System.out.println("jiesu");
			 
		 
         
	}
}
