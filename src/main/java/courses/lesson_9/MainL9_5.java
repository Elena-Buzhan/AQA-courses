package courses.lesson_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainL9_5 {
    public static void main(String[] args) {
        List<String> logins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логины: ");

        while (true) {
            String login = scanner.nextLine();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }

        logins.stream()
                .filter(login -> login.startsWith("f"))
                .forEach(login -> System.out.println(login));
        scanner.close();
    }

}

