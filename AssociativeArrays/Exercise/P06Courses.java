package AssociativeArrays.Exercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> register = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] data = input.split(" : ");
            String course = data[0];
            String studentName = data[1];

            if (register.containsKey(course)) {
                register.get(course).add(studentName);
            }else {
                register.put(course, new ArrayList<>());
                register.get(course).add(studentName);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : register.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue().size());

            for (String person: entry.getValue()) {
                System.out.printf("-- %s%n", person);
            }
        }


    }
}
