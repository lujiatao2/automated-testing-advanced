package com.lujiatao.c10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class SeleniumGridTest {

    @Test(invocationCount = 10)
    public void testCase_001() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.3.12:4444/wd/hub"), chromeOptions);
        driver.get("http://192.168.3.12:9002/login");
        assertEquals(driver.getTitle(), "登录");
        driver.quit();
    }

    @Test(invocationCount = 10)
    public void testCase_002() throws MalformedURLException {
        SafariOptions safariOptions = new SafariOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.3.12:4444/wd/hub"), safariOptions);
        driver.get("http://192.168.3.12:9002/login");
        assertEquals(driver.getTitle(), "登录");
        driver.quit();
    }

}
