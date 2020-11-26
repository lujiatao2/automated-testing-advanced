package com.lujiatao.windowstestcase;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WindowsTestcase {

    @Test
    public void testCase_001() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://192.168.3.12:9002/login");
        assertEquals(driver.getTitle(), "登录");
        driver.quit();
    }

}
