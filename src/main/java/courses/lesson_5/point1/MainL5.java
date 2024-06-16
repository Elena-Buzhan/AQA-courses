package courses.lesson_5.point1;

public class MainL5 {
    public static void main(String[] args) {
        Cat[] allCats = new Cat[2];
        allCats[0] = new Cat("Барсик");
        allCats[1] = new Cat("Мурзик");

        Plate plateForCats = new Plate(10);

        for (int i = 0; i < allCats.length; i++) {
            allCats[i].eat(plateForCats, 6);
            boolean isFedCat = allCats[i].isFed();
            System.out.println("Кот " + allCats[i].name + " сытый? - " + isFedCat);
            //цель накормить всех котов
            if (!isFedCat) {
                plateForCats.addFoodToPlate(1);
                i--;
            }
        }

        //        Cat catBars = new Cat("Барсик");
//        catBars.run(100);
//        catBars.run(200);
//        catBars.swim(10);
//        System.out.println();
//
//        Cat catMur = new Cat("Мурзик");
//        catMur.run(150);
//        catMur.run(190);
//        catMur.swim(9);
//        System.out.println();

//        System.out.println();
//
//
//        Animal dogBob = new Dog("Бобик");
//        dogBob.run(500);
//        dogBob.run(600);
//        dogBob.swim(10);
//        dogBob.swim(11);
//        System.out.println();
//
//        System.out.println("Общее количество котов: " + Cat.getCountCat());
//        System.out.println("Общее количество собак: " + Dog.getCountDog());
//        System.out.println("Общее количество животных: " + Animal.getCountAnimal());
//
//
//        System.out.println();

//        System.out.println("Барсик сытый? - " + catBars.isFed());
//
//        Plate plateForBars = new Plate(10);
//        System.out.println("Количество еды в тарелке до того, как поел кот Барсик: " + plateForBars.getCountFood());
//
//
//        catBars.eat(plateForBars,5);
//        System.out.println("Количество еды в тарелке после того, как поел кот Барсик: " + plateForBars.getCountFood());
//        System.out.println("Барсик сытый? - " + catBars.isFed());


    }
}
