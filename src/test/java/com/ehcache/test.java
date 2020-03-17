package com.ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bingfa.Service;
import com.bingfa.demo;
import com.ehcache緩存.UserRepository;
import com.ehcache緩存.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
	@Autowired
    private UserRepository userRepository;

     
	@Test
	public void contextLoads() {
		User user = userRepository.findByUserId("555");
	}
	 
}
