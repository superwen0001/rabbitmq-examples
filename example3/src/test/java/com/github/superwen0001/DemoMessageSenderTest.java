package com.github.superwen0001;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @author superwen
 * @date 2017/10/25 下午3:57
 */
public class DemoMessageSenderTest extends TestSupport {

    @Autowired
    private DemoMessageSender sender;

    @Test
    public void sendMsg() throws Exception {
        DemoMessage message = new DemoMessage();
        message.setId("1");
        message.setTime(LocalDateTime.now());
        message.setContent("测试内容");
        sender.sendMsg(message);
    }

}