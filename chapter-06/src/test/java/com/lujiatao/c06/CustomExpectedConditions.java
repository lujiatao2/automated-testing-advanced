package com.lujiatao.c06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

public class CustomExpectedConditions {

    public static Function<WebDriver, WebElement> hasWebElement(By locator) {
        return driver -> driver.findElement(locator);
    }

}
