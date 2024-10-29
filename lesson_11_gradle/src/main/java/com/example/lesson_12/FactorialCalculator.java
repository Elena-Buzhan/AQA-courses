package com.example.lesson_12;

public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            long nextResult = result * i;
            // Проверка на переполнение: если nextResult / i не равно result, значит произошло переполнение
            if (nextResult / i != result) {
                throw new ArithmeticException("Переполнение при вычислении факториала для " + n);
            }
            result = nextResult;
        }
        return result;
    }

}
