package com.lujiatao.c06;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SetScriptTimeoutTest {

    @Test(description = "异步执行JavaScript脚本等待超时")
    public void testCase_001() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        long startTime = System.currentTimeMillis();
        driver.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 100000);");
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        driver.quit();
    }

}
