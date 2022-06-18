package AssociativeArrays.Exercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);

        }
        studentsGrades.forEach((key, value)-> {
            double averageGrade = value
                    .stream()
                    .mapToDouble(x -> x)
                    .average()
                    .orElse(0.0);
            if(averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n",key, averageGrade);
            }
        }) ;






//        studentsGrades.entrySet().stream()
//                .filter(s -> s.getValue()
//                        .stream()
//                        .mapToDouble(x -> x)
//                        .average()
//                        .orElse(0.0) >= 4.50)
//                .forEach(entry -> {
//                   double averageGrade = entry.getValue()
//                            .stream()
//                            .mapToDouble(x ->x)
//                            .average()
//                            .orElse(0.0);
//                    System.out.printf("%s -> %.2f%n",entry.getKey(),averageGrade);
//                });



    }
}
