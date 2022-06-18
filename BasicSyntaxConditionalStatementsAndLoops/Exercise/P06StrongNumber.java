package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int number = Integer.parseInt(input);
        int num = number;
        int totalFactorial = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = num % 10;
            num /= 10;
            int factorial = 1;

            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            totalFactorial += factorial;
        }

        if (number == totalFactorial) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
