package ProgrammingFundamentalsExams;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

       int sumNumbers = 0;
       int countNumbers = 0;

        for (int num:numbers) {
            sumNumbers += num;
            countNumbers++;
        }
        double averageNumber = sumNumbers * 1.0 / countNumbers;

       List<Integer> topNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > averageNumber) {
                topNumbers.add(currentNumber);
            }

        }
        Collections.sort(topNumbers);
        Collections.reverse(topNumbers);

        if (topNumbers.size() > 5) {
            topNumbers = topNumbers.subList(0,5);
        }

        topNumbers.forEach(e -> System.out.print(e + " "));

        if (topNumbers.isEmpty()) {
            System.out.println("No");
        }
    }
}
