package com.lujiatao.c10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.lujiatao.c10.Timer.TIMER;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class FirefoxTest {

    @BeforeClass
    public void setUpAll() {
        TIMER.setStartTime();
    }

    @AfterClass
    public void tearDownAll() {
        System.out.println("平均耗时：" + TIMER.getElapsedTime() / 10 + "毫秒");
    }

    @Test(invocationCount = 10)
    public void testCase_001() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://localhost:9002/login");
        driver.findElementByCssSelector("input[type='text']").sendKeys("zhangsan");
        driver.findElementByCssSelector("input[type='password']").sendKeys("zhangsan123456");
        driver.findElementByClassName("el-button").click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement actual = wait.until(presenceOfElementLocated(By.cssSelector("#nav > div:nth-child(2) > span")));
        assertEquals(actual.getText(), "zhangsan");
        driver.quit();
    }

    @Test(invocationCount = 10)
    public void testCase_002() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:9002/login");
        driver.findElementByCssSelector("input[type='text']").sendKeys("zhangsan");
        driver.findElementByCssSelector("input[type='password']").sendKeys("zhangsan123456");
        driver.findElementByClassName("el-button").click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement actual = wait.until(presenceOfElementLocated(By.cssSelector("#nav > div:nth-child(2) > span")));
        assertEquals(actual.getText(), "zhangsan");
        driver.quit();
    }

}
