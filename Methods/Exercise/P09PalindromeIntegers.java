package Methods.Exercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            int number = Integer.parseInt(input);

            if (reversedNumber(number) == number) {
                System.out.println("true");
            }else {
                System.out.println("false");
            }


            input = scanner.nextLine();
        }
    }
    public static int reversedNumber(int number) {
        int reversedNumber = 0;

        while (number != 0) {
            int currentNumber = number % 10;
            reversedNumber = reversedNumber * 10 + currentNumber;
            number = number / 10;
        }
        return reversedNumber;
    }
}
