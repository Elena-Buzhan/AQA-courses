package courses.lesson_4;

public class MainL4 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "QA", "test1@mail.ru", "+344444", 1000, 10);
        employees[1] = new Employee("Petrov Petr", "Developer", "test2@mail.ru", "+9000000000", 2000, 28);
        employees[2] = new Employee("Test Test", "HR", "test3@mail.ru", "+234567", 4500, 43);
        employees[3] = new Employee("Ivanova Kate", "SA", "test4@mail.ru", "+876543223456", 100, 39);
        employees[4] = new Employee("Petrova Olya", "BA", "test5@mail.ru", "+123456789", 1000, 47);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printToConsole();
            }
        }
        System.out.println();

        Park.Attraction attraction1 = new Park.Attraction("Slide", "10.00-20.00", 100);
        Park.Attraction attraction2 = new Park.Attraction("Big wheel", "12.00-18.00", 500);
        System.out.println(attraction1);
        System.out.println();
        System.out.println(attraction2);
    }

}
