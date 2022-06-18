package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int countDays = 0;
        int totalAmount = 0;

        while (startingYield >= 100) {
            countDays++;
            totalAmount += startingYield - 26;
            startingYield -= 10;
        }
        if (totalAmount > 26) {
        totalAmount = totalAmount - 26;
        }

        System.out.println(countDays);
        System.out.println(totalAmount);
    }
}
