package com.organization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitMq.一对一.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracticeApplicationTests {
	@Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
	@Test
	public void contextLoads() {
	}

}
