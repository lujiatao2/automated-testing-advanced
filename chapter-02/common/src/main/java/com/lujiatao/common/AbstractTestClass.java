package com.lujiatao.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class AbstractTestClass {

    public ChromeDriver driver;

    @BeforeClass
    public void setUpAll() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDownAll() {
        driver.quit();
    }

}
