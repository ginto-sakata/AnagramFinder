package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramFinderTest {

    // Тестовые данные
    private final String[] input = {"qwe", "wqe", "qwee", "a", "a"};
    private final String expectedOutput = "a = 3, 4" + System.lineSeparator() + "eqw = 0, 1" + System.lineSeparator();


    // Функция для получения вывода из консоли
    private String captureOutput(Runnable func) {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        func.run();
        return out.toString();
    }

    @Test
    public void testAnagramFinderSimple() {
        String result = captureOutput(() -> AnagramFinderSimple.findAnagrams(input));
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testAnagramFinderAdvanced() {
        String result = captureOutput(() -> AnagramFinderAdvanced.findAnagrams(input));
        assertEquals(expectedOutput, result);
    }
}
