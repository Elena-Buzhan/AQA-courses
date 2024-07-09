package courses.lesson_10;

public class MainL10 {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple());
        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple(), new Apple());

        System.out.println("вес коробки 1 с яблоками: " + appleBox1.getWeight());
        System.out.println("вес коробки 2 с яблоками: " + appleBox2.getWeight());
        System.out.println("пересыапем яблоки из коробки 1 в коробку 2");
        appleBox1.moveFruitToBox(appleBox2);
        System.out.println("вес коробки 1 с яблоками: " + appleBox1.getWeight());
        System.out.println("вес коробки 2 с яблоками: " + appleBox2.getWeight());


        Box<Orange> orangeBox1 = new Box<>(new Orange());
        Box<Orange> orangeBox2 = new Box<>(new Orange(), new Orange(), new Orange());
        System.out.println();
        System.out.println("вес коробки 1 с апельсинами: " + orangeBox1.getWeight());
        System.out.println("вес коробки 2 с апельсинами: " + orangeBox2.getWeight());
        System.out.println("пересыапем апельсины из коробки 2 в коробку 1");
        orangeBox2.moveFruitToBox(orangeBox1);
        System.out.println("вес коробки 1 с апельсинами: " + orangeBox1.getWeight());
        System.out.println("вес коробки 2 с апельсинами: " + orangeBox2.getWeight());

        System.out.println();
        System.out.println("Сравним вес коробки 2 с яблоками с коробкой 1 с апельсинами");
        if (appleBox2.compare(orangeBox1)) {
            System.out.println("Коробки равны по весу");
        } else {
            System.out.println("Коробки не равны по весу");
        }
    }

}
