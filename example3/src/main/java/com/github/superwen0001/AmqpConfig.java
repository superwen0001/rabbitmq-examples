package com.github.superwen0001;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author superwen
 * @date 2017/10/25 下午3:32
 */
@Configuration
public class AmqpConfig {

    public static final String EXCHANGE = "example3-exchange";
    public static final String ROUTINGKEY = "example3-routingKey";
    public static final String QUEUE_NAME = "example3-queue";


    @Autowired
    DemoMessageHandler demoMessageHandler;

    @Autowired
    MyMessageListener myMessageListener;

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME,true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue,DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(ROUTINGKEY);
    }


    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory factory,Queue queue){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(factory);
        container.setQueues(queue);
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认

//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(demoMessageHandler);
//        messageListenerAdapter.setMessageConverter(new Jackson2JsonMessageConverter());
//        container.setMessageListener(messageListenerAdapter);

        container.setMessageListener(myMessageListener);
        return container;
    }




}
