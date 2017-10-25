package com.github.superwen0001;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

/**
 * @author superwen
 * @date 2017/10/25 下午4:12
 */
@Component
@Slf4j
public class MyMessageListener implements ChannelAwareMessageListener {

    Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
//        jackson2JsonMessageConverter.getJ
        DemoMessage demoMessage = (DemoMessage)jackson2JsonMessageConverter.fromMessage(message);
        log.info("receive: "+demoMessage);
    }
}
