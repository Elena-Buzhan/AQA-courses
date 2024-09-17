package com.example.lesson_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(6, FactorialCalculator.factorial(3));
        assertEquals(40320, FactorialCalculator.factorial(8));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1));
        assertEquals("Число должно быть неотрицательным.", exception.getMessage());
    }

}
