package courses.lesson_9;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static courses.lesson_9.Students.students;


public class MainL9 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2, 4, 5);
        System.out.println("Количество четных чисел: " + getCountEvenNumbers(numbers));

        List<String> stringList = List.of("Highload", "High", "Load", "Highload");
        long countHigh = stringList.stream().filter(el -> "High".equals(el)).count();
        System.out.println("Слово \"High\" встречается: " + countHigh + " раз");

        String firstElement = stringList.stream().findFirst().orElse("0");
        System.out.println("Первый элемент в коллекции: " + firstElement);

        String lastElement = stringList.stream().reduce((el1, el2) -> el2).orElse("0");
        System.out.println("Последний элемент в коллекции: " + lastElement);

        List<String> colElements = List.of("f10", "f15", "f2", "f4", "f4");
        String[] sortArr = colElements.stream().sorted().toArray(String[]::new);
        System.out.println("Массив строк в алфавитном порядке: " + Arrays.toString(sortArr));

        double averAge = students.stream()
                .filter(student -> Students.Gender.MAN.equals(student.getGender()))
                .mapToInt(Students.Student::getAge)
                .average()
                .orElse(0);
        System.out.println("Cредний возраст студентов мужского пола: " + averAge);

        List<Students.Student> studentsForDraft = getStudentsForDraft();
        System.out.println("Студентам грозит получение повестки в этом году: ");
        for (Students.Student student : studentsForDraft) {
            System.out.println(student.getName());
        }

    }

    public static long getCountEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).count();
    }

    public static List<Students.Student> getStudentsForDraft() {
        return students.stream()
                .filter(student -> student.getGender().equals(Students.Gender.MAN))
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toList());
    }

}
