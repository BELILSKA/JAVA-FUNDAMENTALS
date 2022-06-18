package ProgrammingFundamentalsExams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequenceOfElements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        String matchElement = "";
        int countMoves = 0;

        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            int firstIndex = Integer.parseInt(data[0]);
            int secondIndex = Integer.parseInt(data[1]);
            int maxIndex = Math.max(firstIndex,secondIndex);
            countMoves++;

            if (firstIndex < 0 || firstIndex >= sequenceOfElements.size() ||
            secondIndex < 0 || secondIndex >= sequenceOfElements.size() || firstIndex == secondIndex) {
                System.out.println("Invalid input! Adding additional elements to the board");
                int indexToInsert = sequenceOfElements.size() / 2;
                String elementToInsert = "-" + countMoves + "a";
                sequenceOfElements.add(indexToInsert,elementToInsert);
                sequenceOfElements.add(indexToInsert,elementToInsert);
                input = scanner.nextLine();
                continue;
            }

            if (Objects.equals(sequenceOfElements.get(firstIndex), sequenceOfElements.get(secondIndex))) {
                matchElement = sequenceOfElements.get(firstIndex);
                System.out.printf("Congrats! You have found matching elements - %s!%n", matchElement);
                if (maxIndex == firstIndex) {
                sequenceOfElements.remove(firstIndex);
                sequenceOfElements.remove(secondIndex);
                }else {
                    sequenceOfElements.remove(secondIndex);
                    sequenceOfElements.remove(firstIndex);
                }
            }else {
                System.out.println("Try again!");
            }

            if (sequenceOfElements.isEmpty()) {
                break;
            }


            input = scanner.nextLine();
        }
        if (!sequenceOfElements.isEmpty()) {
            System.out.println("Sorry you lose :(");
            sequenceOfElements.forEach(e -> System.out.print(e + " "));
        }else {
            System.out.printf("You have won in %d turns!", countMoves);
        }
    }
}
