package com.lujiatao.testcase;

import com.lujiatao.common.AbstractTestClass;
import org.testng.annotations.Test;

import static com.lujiatao.business.LoginLogic.loginSuccess;

public class Login extends AbstractTestClass {

    @Test(description = "登录成功")
    public void testCase_001() throws InterruptedException {
        loginSuccess(driver, "zhangsan", "zhangsan123456");
    }

}
