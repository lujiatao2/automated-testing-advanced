package com.lujiatao.c10;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGTest2 {

    @Test
    public void testCase_001() throws InterruptedException {
        System.out.println("TestNGTest2 >>> testCase_001: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void testCase_002() throws InterruptedException {
        System.out.println("TestNGTest2 >>> testCase_002: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testCase_003() throws InterruptedException {
        System.out.println("TestNGTest2 >>> testCase_003: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(3);
    }

}
