package com.github.superwen0001;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author superwen
 * @date 2017/10/25 下午3:47
 */
@Slf4j
@Component
public class DemoMessageHandler implements MessageHandler<DemoMessage> {
    @Override
    public void handleMessage(DemoMessage message) {
        log.info("receive :" + message);
    }
}
