package Lists.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        double leftSum = 0;
        double rightSum = 0;
        String winner = "";

        for (int i = 0; i < numbers.length / 2; i++) {
            int currentNumber = numbers[i];
            if (currentNumber != 0) {
                leftSum += currentNumber;
            }else {
                leftSum = leftSum * 0.8;
            }
        }
        for (int i = numbers.length - 1; i > numbers.length / 2; i--) {
            int currentNumber = numbers[i];
            if (currentNumber != 0) {
                rightSum += currentNumber;
            }else {
                rightSum = rightSum * 0.8;
            }
        }
        if (leftSum < rightSum) {
            winner = "left";
        }else {
            winner = "right";
        }
        System.out.printf("The winner is %s with total time: %.1f", winner, Math.min(leftSum,rightSum));
    }
}
