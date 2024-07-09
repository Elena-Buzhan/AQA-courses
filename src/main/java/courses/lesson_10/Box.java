package courses.lesson_10;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public void addFruit(T... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void removeFruit(T... items) {
        for (T item : items) {
            this.fruits.remove(item);
        }
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveFruitToBox(Box<? super T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

}
