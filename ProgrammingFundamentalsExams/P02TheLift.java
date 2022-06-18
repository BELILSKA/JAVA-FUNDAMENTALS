package ProgrammingFundamentalsExams;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWaitingPeople = Integer.parseInt(scanner.nextLine());
        int [] currentStateOfTheLift = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        for (int i = 0; i < currentStateOfTheLift.length; i++) {
            int currentWagonSeats = currentStateOfTheLift[i];
            int countPeopleAbleToBoard = 4 - currentWagonSeats;

            if (countWaitingPeople >= countPeopleAbleToBoard) {
                currentStateOfTheLift [i] = countPeopleAbleToBoard + currentStateOfTheLift[i];
                countWaitingPeople = countWaitingPeople - countPeopleAbleToBoard;
            }else {
                currentStateOfTheLift [i] = countWaitingPeople;
                countWaitingPeople = countWaitingPeople - currentStateOfTheLift[i];
                System.out.println("The lift has empty spots!");
                break;
            }

        }
        if (countWaitingPeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", countWaitingPeople);
        }

        for (int i : currentStateOfTheLift) {
            System.out.print(i + " ");
        }


    }
}
