package com.rabbitMq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue OneToManyQueue() {
        return new Queue("onetomany");
    }
    @Bean
    public Queue ManyToManyQueue() {
        return new Queue("manytomany");
    }
}