package com.lujiatao.extentreportingframeworkjenkins;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExtentReportingFrameworkJenkins {

    static {
        System.setProperty("extent.reporter.html.start", "true");
        System.setProperty("extent.reporter.html.out", "test-output/ExtentReportingFramework.html");
    }

    @Test
    public void testCase_001() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://192.168.3.12:9002/login");
        assertEquals(driver.getTitle(), "登录");
        driver.quit();
    }

}
