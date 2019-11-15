package com.rabbitMq.高级使用.FanoutExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.D")
public class FanoutReceiverD {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver D: " + message);
    }

}