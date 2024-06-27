package courses.lesson_8;

import java.util.*;

public class MainL8 {
    public static void main(String[] args) {
        String[] words = new String[]{
                "Тестировщик", "БА", "БА", "СА", "Разработчик", "ПМ", "ПО", "Рекрутер", "ПО", "1С"
        };

        printDetails(words);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Buzhan", "+375291234455");
        phoneBook.add("Buzhan", "+375291234457");
        phoneBook.add("Test", "+375291232758");
        System.out.println();
        System.out.println("Buzhan: " + phoneBook.get("Buzhan"));
        System.out.println("Test: " + phoneBook.get("Test"));
    }


    private static void printDetails(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> countOfWords = new HashMap<>();

        for (String word : words) {
            uniqueWords.add(word);

            if (countOfWords.containsKey(word)) {
                countOfWords.put(word, countOfWords.get(word) + 1);
            } else {
                countOfWords.put(word, 1);
            }
        }


        System.out.println("Уникальные слова: " + uniqueWords);
        System.out.println("Количество уникальных слов: " + uniqueWords.size());

        System.out.println("Количество хождения каждого слова:");
        for (Map.Entry<String, Integer> entry : countOfWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

}
