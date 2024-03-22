package courses.lesson_3;

import java.util.Arrays;

public class MainL3 {
    public static void main(String[] args) {
        System.out.println(isRange(10, 3));
        printPositiveOrNegativeNumber(-1);
        System.out.println(isNegativeNumber(-1));
        printToConsole("Hello", 3);
        System.out.println(isLeapYear(100));
        replace();
        fillArray();
        multiplyingNumbersInArray();
        fillDiagonalElements();
    }

    public static boolean isRange(int a, int b) {
        int sumAB = a + b;
        if (10 < sumAB && sumAB <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void printPositiveOrNegativeNumber(int a) {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean isNegativeNumber(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printToConsole(String string, int amt) {
        for (int i = 0; i < amt; i++) {
            System.out.println(string);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void replace() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("before replace: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println("after replace: " + Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[100];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = j + 1;
            System.out.println("arr[" + j + "] = " + arr[j]);
        }
    }

    public static void multiplyingNumbersInArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("before replace: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println("after replace: " + Arrays.toString(arr));
    }

    public static void fillDiagonalElements() {
        int arr[][] = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            arr[i][arr.length - i - 1] = 1;
            System.out.println(arr[i][i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][i] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

