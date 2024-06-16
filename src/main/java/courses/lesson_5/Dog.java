package courses.lesson_5;

public class Dog extends Animal {

    private static final int MAX_DISTANCE_RUN = 500;
    private static final int MAX_DISTANCE_SWIM = 10;
    private static int countDog;

    public Dog(String name) {
        this.name = name;
        countDog++;
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_DISTANCE_RUN) {
            System.out.println("Собака не умеет так далеко бегать");
        } else {
            System.out.println("Собака " + name + " пробежал " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > MAX_DISTANCE_SWIM) {
            System.out.println("Собака не умеет так далеко плавать");
        } else {
            System.out.println("Собака " + name + " проплыл " + distance + " метров");
        }
    }

    public static int getCountDog() {
        return countDog;
    }

}
