package com.lujiatao.c07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import java.util.List;

import static com.lujiatao.c07.Calculator.add;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitAssertion {

    @Test
    void testCase_001() {
        assertEquals(3, add(1, 1), () -> "期望值与实际值不相等！");
    }

    @Test
    void testCase_002() {
        double expected = 1.0001;
        double actual = getDouble();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    void testCase_003() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = getIntArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testCase_004() {
        List<Integer> expected = asList(1, 2);
        List<Integer> actual = getIntegerList();
        assertIterableEquals(expected, actual);
    }

    @Test
    void testCase_005() {
        assertTrue(add(1, 1) > 1);
        assertTrue(() -> add(1, 1) > 1);
        assertFalse(add(1, 1) <= 1);
        assertFalse(() -> add(1, 1) <= 1);
    }

    @Test
    void testCase_006() {
        Object object = getObject();
        assertNotNull(object);
    }

    @Test
    void testCase_007() {
        List<String> expected = asList("1", ">>>>", "1234");
        List<String> actual = getStringList();
        assertLinesMatch(expected, actual);
    }

    @Test
    void testCase_008() {
        Person actual = new Person("123456", "张三");
        assertAll("Person断言失败",
                () -> assertEquals("123456", actual.getIdCard()),
                () -> assertEquals("张三", actual.getName())
        );
    }

    @Test
    void testCase_009() {
        ThrowingSupplier<String> stringThrowingSupplier = () -> {
            Thread.sleep(1000);
            return "成功！";
        };
        String result = assertTimeoutPreemptively(Duration.ofSeconds(5), stringThrowingSupplier);
        System.out.println(result);
    }

    @Test
    void testCase_010() {
        Executable executable = () -> Thread.sleep(10000);
        long startTime = System.currentTimeMillis();
        try {
            assertTimeout(Duration.ofSeconds(5), executable);
        } catch (AssertionFailedError e) {
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        }
    }

    @Test
    void testCase_011() {
        Executable executable = () -> {
            throw new Exception("Executable异常");
        };
        Exception exception = assertThrows(Exception.class, executable);
        System.out.println(exception.getMessage());
    }

    @Test
    void testCase_012() {
        ThrowingSupplier<String> stringThrowingSupplier = () -> "成功！";
        String result = assertDoesNotThrow(stringThrowingSupplier);
        System.out.println(result);
    }

    @Test
    void testCase_013() {
        fail("失败！");
    }

    private double getDouble() {
        return 1.00001;
    }

    private int[] getIntArray() {
        return new int[]{5, 4, 3, 2, 1};
    }

    private List<Integer> getIntegerList() {
        return asList(1, 2);
    }

    private Object getObject() {
        return new Object();
    }

    private List<String> getStringList() {
        return asList("1", "12", "123", "1234");
    }

}
