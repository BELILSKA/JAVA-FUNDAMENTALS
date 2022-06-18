package ProgrammingFundamentalsExams;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int countWonBattles = 0;

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if (initialEnergy >= distance) {
                countWonBattles++;
                initialEnergy -= distance;
            }else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWonBattles, initialEnergy);
                break;
            }

            if (countWonBattles % 3 == 0) {
                initialEnergy += countWonBattles;
            }


            input = scanner.nextLine();
        }
        if (input.equals("End of battle")) {
        System.out.printf("Won battles: %d. Energy left: %d", countWonBattles, initialEnergy);
        }
    }
}
