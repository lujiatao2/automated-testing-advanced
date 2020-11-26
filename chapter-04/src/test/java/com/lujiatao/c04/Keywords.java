package com.lujiatao.c04;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Keywords {

    private static ChromeDriver driver;

    public static void openChromeBrowser() {
        driver = new ChromeDriver();
    }

    public static void goTo(String url) {
        driver.get(url);
    }

    public static void input(String locator, String value) {
        driver.findElementByCssSelector(locator).sendKeys(value);
    }

    public static void click(String locator) {
        driver.findElementByClassName(locator).click();
    }

    public static void sleep(String seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(Long.parseLong(seconds));
    }

    public static void checkResult(String expected) {
        assertEquals(driver.findElementByCssSelector("#nav > div:nth-child(2) > span").getText(), expected);
    }

    public static void closeChromeBrowser() {
        driver.quit();
    }

}
