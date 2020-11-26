package com.lujiatao.c10;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGTestAnnotationTest {

    @Test(invocationCount = 10, threadPoolSize = 2, timeOut = 4500)
    public void testCase_001() throws InterruptedException {
        System.out.println("TestNGTestAnnotationTest >>> testCase_001: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(1);
    }

}
