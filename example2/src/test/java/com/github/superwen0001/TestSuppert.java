package com.github.superwen0001;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author superwen
 * @date 2017/10/25 上午11:13
 */
@RunWith(SpringJUnit4ClassRunner.class)

// 指定我们SpringBoot工程的Application启动类
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestSuppert {
}
