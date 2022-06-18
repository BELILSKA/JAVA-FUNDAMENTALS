package ProgrammingFundamentalsExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetSequence = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Shoot":
                    int indexToShoot = Integer.parseInt(commandLine[1]);
                    int power = Integer.parseInt(commandLine[2]);

                    int newTargetValue = targetSequence.get(indexToShoot) - power;
                    targetSequence.set(indexToShoot, newTargetValue);
                    if (newTargetValue == 0) {
                        targetSequence.remove(indexToShoot);
                    }
                    break;
                case "Add":
                    int indexToAdd = Integer.parseInt(commandLine[1]);
                    int value = Integer.parseInt(commandLine[2]);

                    if (indexToAdd >= 0 && indexToAdd < targetSequence.size()) {
                        targetSequence.add(indexToAdd, value);
                    }else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int indexToStrike = Integer.parseInt(commandLine[1]);
                    int radius = Integer.parseInt(commandLine[2]);

                    for (int i = targetSequence.get(indexToStrike - radius); i < targetSequence.get(indexToStrike +radius); i++) {
                        targetSequence.remove(targetSequence.get(i));
                        i--;
                    }

                    break;
            }






            input = scanner.nextLine();
        }
        System.out.println();
    }
}
