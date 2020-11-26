package com.lujiatao.c03.datasource;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.lujiatao.c03.datasource.DataSourceUtil.*;
import static org.testng.Assert.assertEquals;

public class Login {

    private ChromeDriver driver;
    private String url;

    @BeforeClass
    public void setUpAll() {
        driver = new ChromeDriver();
        Map<String, Object> yaml = readYaml("configdata.yaml");
        Map<String, String> tmp = (Map<String, String>) yaml.get("login");
        url = tmp.get("url");
    }

    @Test(description = "登录成功", dataProvider = "forTestCase_001")
    public void testCase_001(String username, String password) throws InterruptedException {
        driver.get(url);
        driver.findElementByCssSelector("input[type='text']").sendKeys(username);
        driver.findElementByCssSelector("input[type='password']").sendKeys(password);
        driver.findElementByClassName("el-button").click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals(driver.findElementByCssSelector("#nav > div:nth-child(2) > span").getText(), username);
    }

    @DataProvider(name = "forTestCase_001")
    public Object[][] testData_001() {
        return readDatabase("com.mysql.cj.jdbc.Driver", "jdbc:mysql://192.168.3.102:3306/testdata", "root", "123456", "SELECT * FROM login;");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
