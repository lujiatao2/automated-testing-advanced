package com.lujiatao.c10;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(CONCURRENT)
public class JUnitTestAnnotationExecution {

    @Test
    @Order(2)
    void testCase_001() throws InterruptedException {
        System.out.println("JUnitTestAnnotationExecution >>> testCase_001: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    @Order(3)
    void testCase_002() throws InterruptedException {
        System.out.println("JUnitTestAnnotationExecution >>> testCase_002: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @Order(1)
    void testCase_003() throws InterruptedException {
        System.out.println("JUnitTestAnnotationExecution >>> testCase_003: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(3);
    }

}
