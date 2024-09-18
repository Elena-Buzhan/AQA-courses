package com.example.lesson_12;

import org.testng.annotations.Test;

import static com.example.lesson_12.FactorialCalculator.factorial;
import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTestng {

    @Test
    public void testFactorialOfZero() {
        assertEquals(factorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(factorial(1), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(factorial(3), 6);
        assertEquals(factorial(8), 40320);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число должно быть неотрицательным.")
    public void testFactorialOfNegativeNumber() {
        factorial(-1);
    }

}
