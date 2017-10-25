package com.github.superwen0001;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import java.time.LocalDateTime;

/**
 * @author superwen
 * @date 2017/10/25 下午4:23
 */
@Slf4j
public class ConverterTest {

    @Test
    public void test1(){
        DemoMessage demoMessage = new DemoMessage();
        demoMessage.setId("1");
        demoMessage.setTime(LocalDateTime.now());
        demoMessage.setContent("测试内容");

        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        Message message = converter.toMessage(demoMessage, new MessageProperties());

        Object object = converter.fromMessage(message);
        log.info("--"+object);
    }
}
