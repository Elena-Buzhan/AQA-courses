package courses.lesson_5.point1;

public abstract class Animal {
    public String name;
    private static int countAnimal;

    public Animal() {
        countAnimal++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getCountAnimal() {
        return countAnimal;
    }


}
