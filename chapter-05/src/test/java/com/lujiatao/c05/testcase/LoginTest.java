package com.lujiatao.c05.testcase;

import com.lujiatao.c05.businesslogic.LoginAndLogout;
import com.lujiatao.c05.pageobject.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    private ChromeDriver driver;

    @BeforeClass
    public void setUpAll() {
        driver = new ChromeDriver();
    }

    @Test(description = "登录注销成功")
    public void testCase_001() throws InterruptedException {
        LoginAndLogout loginAndLogout = new LoginAndLogout(driver);
        LoginPage loginPage = loginAndLogout.loginAndLogout("zhangsan", "zhangsan123456");
        assertEquals(loginPage.getPageLoadedSign(), "库存管理系统");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
