package AssociativeArrays.Exercise;

import java.util.*;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> studentsResults = new LinkedHashMap<>();
        Map<String, Integer> languages = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] data = input.split("-");
            String name = data[0];

            if (data[1].equals("banned")) {
                studentsResults.remove(name);
            } else {
                String language = data[1];
                int points = Integer.parseInt(data[2]);
                if (!studentsResults.containsKey(name)) {
                    studentsResults.put(name, points);
                }else if (studentsResults.containsKey(name) && studentsResults.get(name) < points) {
                    studentsResults.put(name, points);
                }

                if (!languages.containsKey(language)) {
                    languages.put(language, 1);
                }else {
                    languages.put(language, languages.get(language) + 1);
                }

            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        studentsResults.forEach((key, value) -> System.out.printf("%s | %s%n", key, value));
        System.out.println("Submissions:");
        languages.forEach((key, value)-> System.out.printf("%s - %s%n", key, value));




    }
}
