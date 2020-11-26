package com.lujiatao.business;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginLogic {

    public static void loginSuccess(ChromeDriver driver, String username, String password) throws InterruptedException {
        driver.get("http://localhost:9002/login");
        driver.findElementByCssSelector("input[type='text']").sendKeys(username);
        driver.findElementByCssSelector("input[type='password']").sendKeys(password);
        driver.findElementByClassName("el-button").click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals(driver.findElementByCssSelector("#nav > div:nth-child(2) > span").getText(), username);
    }

}
