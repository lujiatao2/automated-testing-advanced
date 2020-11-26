package com.lujiatao.c08;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.print("+Success+");
    }

    public void onTestFailure(ITestResult result) {
        System.out.print("+Failure+");

    }

    public void onTestSkipped(ITestResult result) {
        System.out.print("+Skipped+");
    }

}
