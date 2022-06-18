package Methods.Exercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", factorialDivision(firstNum, secondNum));

    }
    public static double factorialDivision (int firstNum, int secondNum) {
        double firstNumFactorial = 1;
        for (int i = 1; i <= firstNum; i++) {
            firstNumFactorial *= i;
        }
        double secondNumFactorial = 1;
        for (int i = 1; i <= secondNum; i++) {
            secondNumFactorial *= i;
        }
        return firstNumFactorial / secondNumFactorial;
    }
}
