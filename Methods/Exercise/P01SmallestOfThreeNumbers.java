package Methods.Exercise;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        smallestOfThreeIntegers(firstNumber, secondNumber, thirdNumber);

    }

    public static void smallestOfThreeIntegers(int firstNumber, int secondNumber, int thirdNumber) {

        if (firstNumber < secondNumber && firstNumber < thirdNumber) {
            System.out.println(firstNumber);
        } else if (secondNumber < firstNumber && secondNumber < thirdNumber) {
            System.out.println(secondNumber);
        } else {
            System.out.println(thirdNumber);
        }
    }
}
