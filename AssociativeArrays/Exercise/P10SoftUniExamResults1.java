package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Integer> users = new LinkedHashMap<>();
        Map<String, Integer> languages = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] data = input.split("-");
            String username = data[0];

            if (data.length == 3) {
                String language = data[1];
                int points = Integer.parseInt(data[2]);

                if (!users.containsKey(username)) {
                    users.put(username,points);
                }else {
                    if (users.get(username) < points) {
                        users.put(username,points);
                    }
                }

                if (!languages.containsKey(language)) {
                    languages.put(language,1);
                }else {
                    languages.put(language, languages.get(language) + 1);
                }
            }else {
                users.remove(username);
            }

            input = scanner.nextLine();
        }
        System.out.println("Results:");
        users.forEach((k,v)-> System.out.printf("%s | %d%n", k,v));
        System.out.println("Submissions:");
        languages.forEach((k,v)-> System.out.printf("%s - %d%n",k,v));
    }
}
