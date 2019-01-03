package com.goldmantis.process;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTwo {
    /**
     * 包名要和启动类的包名相同才行
     */
    @Test
    public void testDemo() {
        System.out.println("a");
    }
}
