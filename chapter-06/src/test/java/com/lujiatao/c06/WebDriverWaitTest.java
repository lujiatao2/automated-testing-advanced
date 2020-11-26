package com.lujiatao.c06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class WebDriverWaitTest {

    @Test(description = "登录成功")
    public void testCase_001() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:9002/login");
        driver.findElementByCssSelector("input[type='text']").sendKeys("zhangsan");
        driver.findElementByCssSelector("input[type='password']").sendKeys("zhangsan123456");
        driver.findElementByClassName("el-button").click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        long startTime = System.currentTimeMillis();
        WebElement username = webDriverWait.until(presenceOfElementLocated(By.cssSelector("#nav > div:nth-child(2) > span")));
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        assertEquals(username.getText(), "zhangsan");
        driver.quit();
    }

}
