package ProgrammingFundamentalsExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TheLift2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        List<Integer> currentStateOfTheLift = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = 4;

        for (int i = 0; i < currentStateOfTheLift.size(); i++) {
            int currentWagonPlaces = currentStateOfTheLift.get(i);
            int countPeopleAbleToBoard = maxCapacity - currentWagonPlaces;

            if (currentWagonPlaces < maxCapacity && waitingPeople > 0 ) {
                if (waitingPeople - countPeopleAbleToBoard >= 0) {
                currentStateOfTheLift.set(i,countPeopleAbleToBoard + currentWagonPlaces);
                waitingPeople -= countPeopleAbleToBoard;
                }else {
                    currentStateOfTheLift.set(i, waitingPeople);
                    System.out.println("The lift has empty spots!");
                    break;
                }
            }
        }
        if (waitingPeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
        }
        currentStateOfTheLift.forEach(e -> System.out.print(e + " "));
    }
}
