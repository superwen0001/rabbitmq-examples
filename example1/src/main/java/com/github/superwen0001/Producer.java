package com.github.superwen0001;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

/**
 * @author superwen
 * @date 2017/10/25 上午10:11
 */
public class Producer {

    public static final String QUEUE_NAME = "example1";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = LocalDateTime.now().toString();
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("send: "+message);
        channel.close();
        connection.close();

    }
}
