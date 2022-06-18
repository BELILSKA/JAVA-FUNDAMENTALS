package ProgrammingFundamentalsExams;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetSequence = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String input = scanner.nextLine();
        int countShotTargets = 0;

        while (!input.equals("End")) {
            int indexOfTarget = Integer.parseInt(input);

            if (indexOfTarget >= targetSequence.length) {
                input = scanner.nextLine();
                continue;
            }

            int valueOfTarget = targetSequence[indexOfTarget];
            targetSequence[indexOfTarget] = -1;
            countShotTargets++;

            for (int i = 0; i < targetSequence.length; i++) {
                int currentTarget = targetSequence[i];

                if (currentTarget <= valueOfTarget && currentTarget > - 1) {
                    currentTarget += valueOfTarget;
                    targetSequence[i] = currentTarget;
                }else if (currentTarget > valueOfTarget){
                    currentTarget -= valueOfTarget;
                    targetSequence[i] = currentTarget;
                }
            }



            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countShotTargets);
        for (int num:targetSequence) {
            System.out.print(num + " ");
        }


    }
}
