package com.github.superwen0001;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author superwen
 * @date 2017/10/25 上午11:39
 */
public class SendTest extends TestSuppert{

    @Autowired
    private Send send;

    @Test
    public void test1(){
        send.sendMsg("aaa");
    }
}