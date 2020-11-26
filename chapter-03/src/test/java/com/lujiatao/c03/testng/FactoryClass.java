package com.lujiatao.c03.testng;

import org.testng.annotations.Factory;

public class FactoryClass {

    @Factory(indices = 1)
    public Object[] createTestClasses_001() {
        return new Object[]{
                new Login("zhangsan", "zhangsan123456"),
                new Login("lisi", "lisi123456")
        };
    }

    @Factory(enabled = false)
    public Object[] createTestClasses_002() {
        return new Object[]{
                new Login("wangwu", "wangwu123456")
        };
    }

}
