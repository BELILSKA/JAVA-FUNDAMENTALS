package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> commandLine = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            String command = commandLine.get(0);

            switch (command) {
                case "Add":
                    int numToAdd = Integer.parseInt(commandLine.get(1));
                    numbers.add(numToAdd);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(commandLine.get(1));
                    int indexToInsert = Integer.parseInt(commandLine.get(2));

                    if (indexToInsert >= numbers.size() || indexToInsert < 0) {
                        System.out.println("Invalid index");
                        input = scanner.nextLine();
                        continue;
                    }
                    numbers.add(indexToInsert, numToInsert);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandLine.get(1));

                    if (indexToRemove >= numbers.size() || indexToRemove < 0) {
                        System.out.println("Invalid index");
                        input = scanner.nextLine();
                        continue;
                    }
                        numbers.remove(indexToRemove);
                    break;
                case "Shift":
                    int count = Integer.parseInt(commandLine.get(2));
                    if (commandLine.get(1).equals("left")) {
                        for (int i = 0; i < count; i++) {
                            int currentNum = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(currentNum);
                        }

                    } else {
                        if (commandLine.get(1).equals("right")) {
                            for (int i = 0; i < count; i++) {
                                int currentNum = numbers.get(numbers.size() - 1);
                                numbers.remove(numbers.get(numbers.size() - 1));
                                numbers.add(0,currentNum);
                            }

                        }
                    }
                        break;

            }
            input = scanner.nextLine();
        }
        numbers.forEach(el -> System.out.print(el + " "));
    }
}
