package com.lujiatao.c03.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginForJUnit {

    @ParameterizedTest
    @ArgumentsSources(@ArgumentsSource(ArgumentsProviderClass.class))
    void testCase_001(String url, String username, String password) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElementByCssSelector("input[type='text']").sendKeys(username);
        driver.findElementByCssSelector("input[type='password']").sendKeys(password);
        driver.findElementByClassName("el-button").click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals(username, driver.findElementByCssSelector("#nav > div:nth-child(2) > span").getText());
        driver.quit();
    }

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("http://localhost:9002/login", "zhangsan", "zhangsan123456"),
                Arguments.of("http://localhost:9002/login", "lisi", "lisi123456")
        );
    }

    @ParameterizedTest
    @EnumSource(value = Role.class, names = {"GUEST", "USER"})
    void testCase_002(Role role) {
        assertNotNull(role);
    }

    enum Role {GUEST, USER, ADMIN}

}
