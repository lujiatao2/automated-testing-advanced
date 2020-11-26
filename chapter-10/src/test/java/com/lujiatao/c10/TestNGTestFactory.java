package com.lujiatao.c10;

import org.testng.annotations.Factory;

public class TestNGTestFactory {

    @Factory
    public Object[] createTestNGTest1() {
        return new Object[]{
                new TestNGTest1(),
                new TestNGTest1()
        };
    }

}
