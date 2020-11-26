package com.lujiatao.c10;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGTest3 {

    @Test
    public void testCase_001() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void testCase_002() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

}
