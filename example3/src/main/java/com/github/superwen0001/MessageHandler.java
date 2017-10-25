package com.github.superwen0001;

import com.rabbitmq.client.Channel;

/**
 * @author superwen
 * @date 2017/10/25 下午3:34
 */
public interface MessageHandler<T> {

     void handleMessage(T message);

}
