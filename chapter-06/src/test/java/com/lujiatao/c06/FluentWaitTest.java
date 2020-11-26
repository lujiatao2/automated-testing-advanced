package com.lujiatao.c06;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.lujiatao.c06.CustomExpectedConditions.hasWebElement;
import static org.testng.Assert.assertEquals;

public class FluentWaitTest {

    @Test(description = "登录成功")
    public void testCase_001() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:9002/login");
        driver.findElementByCssSelector("input[type='text']").sendKeys("zhangsan");
        driver.findElementByCssSelector("input[type='password']").sendKeys("zhangsan123456");
        driver.findElementByClassName("el-button").click();
        Wait<ChromeDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        WebElement username = wait.until(hasWebElement(By.cssSelector("#nav > div:nth-child(2) > span")));
        assertEquals(username.getText(), "zhangsan");
        driver.quit();
    }

}
