package com.lujiatao.c06;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ImplicitlyWaitTest {

    @Test(description = "登录成功")
    public void testCase_001() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:9002/login");
        WebElement username = null;
        long startTime = System.currentTimeMillis();
        try {
            username = driver.findElementByCssSelector("input[type='text111']");
        } catch (NoSuchElementException e) {
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        username.sendKeys("zhangsan");
        driver.findElementByCssSelector("input[type='password']").sendKeys("zhangsan123456");
        driver.findElementByClassName("el-button").click();
        Thread.sleep(3000);
        assertEquals(driver.findElementByCssSelector("#nav > div:nth-child(2) > span").getText(), "zhangsan");
        driver.quit();
    }

}
