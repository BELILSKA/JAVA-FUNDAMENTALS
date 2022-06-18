package Methods.Exercise;

import java.util.Scanner;

public class P08FactorialDivision1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        long firstNumFactorial = calculateFactorial(firstNum);
        long secondNumFactorial = calculateFactorial(secondNum);

        double result = firstNumFactorial * 1.0 / secondNumFactorial;
        System.out.printf("%.2f", result);

    }
    public static long calculateFactorial (int number) {
        long numberFactorial = 1;
        for (int i = 1; i <= number; i++) {
            numberFactorial *= i;
        }
        return numberFactorial;
    }
}
