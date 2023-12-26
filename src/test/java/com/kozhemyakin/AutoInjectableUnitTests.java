package com.kozhemyakin;

import com.kozhemyakin.lab4.Injector;
import com.kozhemyakin.lab4.SomeBean;
import org.junit.jupiter.api.TestInstance;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


/**
 * @author n.s.kozhemyakin
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AutoInjectableUnitTests {
    /**
     * ByteArrayOutputStream to capture the output stream for assertion purposes.
     */
    private final static ByteArrayOutputStream output = new ByteArrayOutputStream();
    /**
     * Constructs a new `AutoInjectableUnitTests` object.
     */
    public AutoInjectableUnitTests() {}
    /**
     * Before all tests, redirects the standard output to the `output` stream to capture
     * the printed content.
     */
    @BeforeAll
    public static void interceptPrintStream() {
        System.setOut(new PrintStream(output));
    }
    /**
     * After each test, clears the `output` stream to ensure a clean state for the next test.
     */
    @AfterEach
    public void clearPrintStream() {
        output.reset();
    }
    /**
     * The file paths for two different property files used in the tests.
     */
    private final static String firstPath = "src/test/resources/first.properties";
    private final static String secondPath = "src/test/resources/second.properties";
    /**
     * Tests the injection of dependencies A and C into a `SomeBean` object using the first property file.
     * Verifies that the `foo` method prints "A" and "C" to the standard output.
     */
    @Test
    public void testInjectAC() {
        SomeBean someBean = null;
        try {
            someBean = (new Injector().inject(new SomeBean(), firstPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        someBean.foo();
        String lineSeparator = System.getProperty("line.separator");
        assertEquals("A" + lineSeparator + "C" + lineSeparator, output.toString());
    }
    /**
     * Tests the injection of dependencies B and C into a `SomeBean` object using the second property file.
     * Verifies that the `foo` method prints "B" and "C" to the standard output.
     */
    @Test
    public void testInjectBC() {
        SomeBean someBean = null;
        try {
            someBean = (new Injector().inject(new SomeBean(), secondPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        someBean.foo();
        String lineSeparator = System.getProperty("line.separator");
        assertEquals("B" + lineSeparator + "C" + lineSeparator, output.toString());
    }
    /**
     * Tests that calling the `foo` method on a new `SomeBean` object without injection results in a `NullPointerException`.
     */
    @Test
    public void testFieldsNotInitialized() {
        assertThrows(NullPointerException.class, () -> {
            (new SomeBean()).foo();
        });
    }
}