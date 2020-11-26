package com.lujiatao.c05.businesslogic;

import com.lujiatao.c05.pageobject.GoodsPage;
import com.lujiatao.c05.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginAndLogout {

    private WebDriver driver;

    public LoginAndLogout(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginAndLogout(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver).get();
        GoodsPage goodsPage = loginPage.login(username, password, GoodsPage.class);
        assertEquals(goodsPage.getPageLoadedSign(), username);
        return goodsPage.logout();
    }

}
