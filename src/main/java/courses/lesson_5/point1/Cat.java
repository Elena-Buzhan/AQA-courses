package courses.lesson_5.point1;

public class Cat extends Animal {
    private static final int MAX_DISTANCE = 200;
    private static int countCat;
    private boolean isFed;

    public Cat(String name) {
        this.name = name;
        countCat++;
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_DISTANCE) {
            System.out.println("Кот не умеет так далеко бегать");
        } else {
            System.out.println("Кот " + name + " пробежал " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

    public void eat(Plate plate, int countEatingFood) {
        if (plate.getCountFood() >= countEatingFood) {
            plate.setCountFood(plate.getCountFood() - countEatingFood);
            this.isFed = true;
        } else {
            System.out.println("В тарелке недостаточно еды");
        }
    }

    public static int getCountCat() {
        return countCat;
    }

    public boolean isFed() {
        return isFed;
    }

    public void setFed(boolean fed) {
        this.isFed = fed;
    }

}
