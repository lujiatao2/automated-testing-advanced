package com.lujiatao.c03.testng;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "forTestCase_001")
    public Object[][] testData_001() {
        return new Object[][]{
                new Object[]{"zhangsan", "zhangsan123456"},
                new Object[]{"lisi", "lisi123456"}
        };
    }

}
