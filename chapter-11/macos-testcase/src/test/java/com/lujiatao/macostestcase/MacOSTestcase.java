package com.lujiatao.macostestcase;

import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MacOSTestcase {

    @Test
    public void testCase_001() {
        SafariDriver driver = new SafariDriver();
        driver.get("http://192.168.3.12:9002/login");
        assertEquals(driver.getTitle(), "登录");
        driver.quit();
    }

}
