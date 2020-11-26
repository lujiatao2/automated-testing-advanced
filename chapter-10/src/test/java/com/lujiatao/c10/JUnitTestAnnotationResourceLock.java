package com.lujiatao.c10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ;
import static org.junit.jupiter.api.parallel.Resources.SYSTEM_PROPERTIES;

public class JUnitTestAnnotationResourceLock {

    private Properties properties;

    @BeforeEach
    void setUp() {
        properties = new Properties();
        properties.putAll(System.getProperties());
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = READ)
    void testCase_001() {
        assertNull(System.getProperty("my.property"));
    }

    @Test
    @ResourceLock(SYSTEM_PROPERTIES)
    void testCase_002() {
        System.setProperty("my.property", "TestNG");
        assertEquals("TestNG", System.getProperty("my.property"));
    }

    @Test
    @ResourceLock(SYSTEM_PROPERTIES)
    void testCase_003() {
        System.setProperty("my.property", "JUnit");
        assertEquals("JUnit", System.getProperty("my.property"));
    }

    @AfterEach
    void tearDown() {
        System.setProperties(properties);
    }

}
