package com.lujiatao.allurejenkins;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AllureJenkins {

    @Test
    public void testCase_001() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://192.168.3.12:9002/login");
        assertEquals(driver.getTitle(), "登录");
        driver.quit();
    }

}
