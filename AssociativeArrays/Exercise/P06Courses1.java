package AssociativeArrays.Exercise;

import java.util.*;

public class P06Courses1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> register = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] coursesData = input.split(" : ");
            String courseName = coursesData[0];
            String studentName = coursesData[1];

            if (!register.containsKey(courseName)) {
                register.put(courseName, new ArrayList<>());
                register.get(courseName).add(studentName);
            }else {
                register.get(courseName).add(studentName);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : register.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue().size());

            entry.getValue().stream().forEach((v)-> System.out.printf("-- %s%n", v));
        }
    }

    }
