package Methods.Exercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//•Its sum of digits is divisible by 8, e.g. 8, 16, 88.
//•	Holds at least one odd digit, e.g. 232, 707, 87578.

        for (int i = 1; i <= n; i++) {
            if (isSumOfDigitsDivisible(i) && isHoldOddDigit(i)) {
                System.out.println(i);
            }
        }


    }
    public static boolean isSumOfDigitsDivisible (int number) {

        int sumOfDigits = 0;

        while (number != 0) {
            int digit = number % 10;
            sumOfDigits += digit;
            number = number / 10;
        }
        return sumOfDigits % 8 == 0;
    }
    public static boolean isHoldOddDigit (int number) {

        while (number != 0) {
            int digit = number % 10;

            if (digit % 2 != 0) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }
}
