package com.lujiatao.c03.testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Login {

    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Test(description = "登录成功")
    public void testCase_001() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:9002/login");
        driver.findElementByCssSelector("input[type='text']").sendKeys(username);
        driver.findElementByCssSelector("input[type='password']").sendKeys(password);
        driver.findElementByClassName("el-button").click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals(driver.findElementByCssSelector("#nav > div:nth-child(2) > span").getText(), username);
        driver.quit();
    }

}
