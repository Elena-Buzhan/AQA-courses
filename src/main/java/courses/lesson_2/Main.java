package courses.lesson_2;

public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a=-1;
        int b=1;
        int c=a+b;
        if (c>=0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        int value=100;
        if (value<=0) {
            System.out.println("Красный");
        } else if (value<=100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

}

    public static void compareNumbers() {
        int a=10;
        int b=11;
        if (a>=b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
}

}
