package courses.lesson_5;

public class Plate {
    private int countFood;

    public Plate() {
    }

    public Plate(int countFood) {
        this.countFood = countFood;
    }

    public int getCountFood() {
        return countFood;
    }

    public void setCountFood(int countFood) {
        this.countFood = countFood;
    }

    public void addFoodToPlate(int addFood) {
        this.countFood += addFood;
    }

}
