package com.lujiatao.c07;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestNGAssertion {

    @Test
    public void testCase_001() {
        String expected = "qwerty";
        String actual = getString();
        assertEquals(actual, expected, "实际字符串与期望字符串不相等！");
    }

    @Test
    public void testCase_002() {
        double expected = 1.0001;
        double actual = getDouble();
        assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCase_003() {
        Object[] expected = {1, 2, 3, 4, 5};
        Object[] actual = getObjectArray();
        assertEqualsNoOrder(actual, expected);
    }

    @Test
    public void testCase_004() {
        int num = getInt();
        assertTrue(num < 10);
        assertFalse(num < 5);
    }

    @Test
    public void testCase_005() {
        Object object = getObject();
        assertNotNull(object);
    }

    @Test
    public void testCase_006() {
        ThrowingRunnable throwingRunnable = getThrowingRunnable();
        assertThrows(throwingRunnable);
        assertThrows(Exception.class, throwingRunnable);
        Exception exception = expectThrows(Exception.class, throwingRunnable);
        System.out.print(exception.getMessage());
    }

    @Test
    public void testCase_007() {
        fail("失败！");
    }

    private String getString() {
        return "qwerty2";
    }

    private double getDouble() {
        return 1.00001;
    }

    private Object[] getObjectArray() {
        return new Object[]{5, 4, 3, 2, 1};
    }

    private int getInt() {
        return 9;
    }

    private Object getObject() {
        return new Object();
    }

    private ThrowingRunnable getThrowingRunnable() {
        return () -> {
            throw new Exception("ThrowingRunnable异常");
        };
    }

}
