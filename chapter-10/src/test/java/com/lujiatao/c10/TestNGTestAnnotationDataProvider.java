package com.lujiatao.c10;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGTestAnnotationDataProvider {

    @Test(dataProvider = "dataProvider_001")
    public void testCase_001(int a, int b) throws InterruptedException {
        System.out.println("TestNGTestAnnotationDataProvider >>> testCase_001: " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(a + b);
    }

    @DataProvider(name = "dataProvider_001", parallel = true)
    public Object[][] dataProvider_001() {
        return new Object[][]{
                new Object[]{1, 0},
                new Object[]{1, 1},
                new Object[]{1, 2}
        };
    }

}
