package com.lujiatao.c10;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class JUnitTest1 {

    @Test
    void testCase_001() throws InterruptedException {
        System.out.println("JUnitTest1 >>> testCase_001: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    void testCase_002() throws InterruptedException {
        System.out.println("JUnitTest1 >>> testCase_002: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    void testCase_003() throws InterruptedException {
        System.out.println("JUnitTest1 >>> testCase_003: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    void testCase_004() throws InterruptedException {
        System.out.println("JUnitTest1 >>> testCase_004: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(4);
    }

    @Test
    void testCase_005() throws InterruptedException {
        System.out.println("JUnitTest1 >>> testCase_005: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(5);
    }

}
