package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
           long firstNum = Long.parseLong(input[0]);
           long secondNum = Long.parseLong(input[1]);

           long greaterNum = Math.max(firstNum, secondNum);
           greaterNum = Math.abs(greaterNum);

            long sum = 0;
            while (greaterNum > 0) {
                sum += greaterNum % 10;
                greaterNum = greaterNum / 10;
            }
            System.out.println(Math.abs(sum));

        }
    }
}
