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

    @Test
    void testFactorialUpperRange() {
        // Тестирование верхней границы в пределах long
        assertEquals(2432902008176640000L, factorial(20), "Факториал 20 должен быть корректным");

        // Тестируем переполнение для числа 21 и ожидаем исключение
        assertThrows(ArithmeticException.class, () -> factorial(21), "Ожидается переполнение для факториала 21");
    }

    @Test
    void testFactorialNegative() {
        // Тестирование отрицательного числа и ожидание исключения
        assertThrows(IllegalArgumentException.class, () -> factorial(-1), "Ожидается исключение для отрицательного числа");
    }

}
