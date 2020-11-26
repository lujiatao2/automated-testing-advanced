package com.lujiatao.c08;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.fail;

@Listeners(ExtentIReporterSuiteClassListenerAdapter.class)
public class TestNGReport {

    static {
        Date date = new Date();
        String str = "-yyyMMddHHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        ExtentKlovReporter klov = new ExtentKlovReporter("TestNGReport", "ExtentReportKlov" + simpleDateFormat.format(date));
        klov.initMongoDbConnection("localhost");
        klov.initKlovServerConnection("http://localhost/");
        new ExtentReports().attachReporter(klov);
    }

    @Test
    public void testCase_001() {
    }

    @Test
    public void testCase_002() {
    }

    @Test
    public void testCase_003() {
    }

    @Test
    public void testCase_004() {
        fail();
    }

    @Test
    public void testCase_005() {
        fail();
    }

    @Test(dependsOnMethods = "testCase_005")
    public void testCase_006() {
    }

}
