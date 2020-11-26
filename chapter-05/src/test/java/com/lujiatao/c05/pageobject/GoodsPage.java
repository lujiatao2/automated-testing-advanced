package com.lujiatao.c05.pageobject;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.Assert.assertEquals;

public class GoodsPage extends AbstractIndexPage<GoodsPage> {

    public GoodsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        driver.get("http://localhost:9002/goods");
    }

    @Override
    protected void isLoaded() {
        String title = driver.getTitle();
        assertEquals(title, "物品管理");
    }

    public static GoodsPage goToGoodsPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("浏览器驱动为空！");
        }
        driver.get("http://localhost:9002/goods");
        return initElements(driver, GoodsPage.class);
    }

    //省略其他操作

}
