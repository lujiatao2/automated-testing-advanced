package com.lujiatao.c05.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public abstract class AbstractIndexPage<T extends AbstractIndexPage<T>> extends AbstractPage<T> {

    @FindBy(css = "#nav > div:nth-child(2) > span")
    private WebElement username;
    @FindBy(className = "el-dropdown-link")
    private WebElement settings;
    @FindBy(className = "el-dropdown-menu__item")
    private WebElement logout;

    public AbstractIndexPage(WebDriver driver) {
        super(driver);
    }

    public String getPageLoadedSign() {
        return username.getText();
    }

    public AbstractPage<T> clickSettings() throws InterruptedException {
        settings.click();
        TimeUnit.SECONDS.sleep(3);
        return this;
    }

    public LoginPage clickLogout() throws InterruptedException {
        logout.click();
        TimeUnit.SECONDS.sleep(3);
        return new LoginPage(driver);
    }

    public LoginPage logout() throws InterruptedException {
        clickSettings();
        return clickLogout();
    }

    //省略其他操作

}
