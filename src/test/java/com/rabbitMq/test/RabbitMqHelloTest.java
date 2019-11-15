package com.rabbitMq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitMq.一对一.HelloSender;
import com.rabbitMq.一对多.NeoSender;
import com.rabbitMq.多对多.ManySender;
import com.rabbitMq.多对多.ManySender2;
import com.rabbitMq.高级使用.对象发送接收.ObjectSender;
import com.rabbitMq.高级使用.对象发送接收.User;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
    /**
     * 一对多,一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
     */
    @Autowired
    private NeoSender neoSender;
    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
        }
    }
    /**
     * 和一对多一样，接收端仍然会均匀接收到消息
     */
    @Autowired
    private ManySender ManySender;
    @Autowired
    private ManySender2 ManySender2;
    @Test
    public void manyToMany() throws Exception {
    	for (int i=0;i<100;i++){
    		ManySender.send("ManySender",i);
    		ManySender2.send("ManySender2",i);
    	}
    }
    /**
     * 对象的支持
     */
    @Autowired
	private ObjectSender sender;

	@Test
	public void sendOject() throws Exception {
		User user=new User();
		user.setName("neo");
		user.setPass("123456");
		sender.send(user);
	}
}