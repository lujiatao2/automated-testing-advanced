package com.lujiatao.c05.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractPage<T extends AbstractPage<T>> extends LoadableComponent<T> {

    public WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

}
