package com.lujiatao.c08;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyReporter.class)
public class SendReport {

    @Test
    public void testCase_001() {
    }

}
