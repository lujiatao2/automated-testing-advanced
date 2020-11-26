package com.lujiatao.c10;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class JUnitTest2 {

    @Test
    void testCase_001() throws InterruptedException {
        System.out.println("JUnitTest2 >>> testCase_001: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    void testCase_002() throws InterruptedException {
        System.out.println("JUnitTest2 >>> testCase_002: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(2);
    }

}
