package com.lujiatao.c05.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.Assert.assertEquals;

public class LoginPage extends AbstractPage<LoginPage> {

    @FindBy(tagName = "h1")
    private WebElement appName;
    @FindBy(css = "input[type='text']")
    private WebElement username;
    @FindBy(css = "input[type='password']")
    private WebElement password;
    @FindBy(className = "el-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        driver.get("http://localhost:9002/login");
    }

    @Override
    protected void isLoaded() {
        String title = driver.getTitle();
        assertEquals(title, "登录");
    }

    public static LoginPage goToLoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("浏览器驱动为空！");
        }
        driver.get("http://localhost:9002/login");
        return initElements(driver, LoginPage.class);
    }

    public String getPageLoadedSign() {
        return appName.getText();
    }

    public LoginPage inputUsername(String username) {
        this.username.sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public <T> T clickLoginButton(Class<T> pageClass) throws InterruptedException {
        loginButton.click();
        TimeUnit.SECONDS.sleep(3);
        return initElements(driver, pageClass);
    }

    public <T> T login(String username, String password, Class<T> pageClass) throws InterruptedException {
        inputUsername(username);
        inputPassword(password);
        return clickLoginButton(pageClass);
    }

}
