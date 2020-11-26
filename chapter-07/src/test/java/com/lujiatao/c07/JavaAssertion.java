package com.lujiatao.c07;

import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAssertion {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:9002/login");
        assert driver.getTitle().equals("首页") : "页面标题错误！";
        driver.quit();
    }

}
