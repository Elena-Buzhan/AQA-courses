package com.example.lesson_12;

import org.junit.jupiter.api.Test;

import static com.example.lesson_12.FactorialCalculator.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, factorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, factorial(1));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(6, factorial(3));
        assertEquals(40320, factorial(8));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial(-1));
        assertEquals("Число должно быть неотрицательным.", exception.getMessage());
    }

}
