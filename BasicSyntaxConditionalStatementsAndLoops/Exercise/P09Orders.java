package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOrders = Integer.parseInt(scanner.nextLine());

        double totalCoffeePrice = 0;

        for (int i = 1; i <= countOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());


            double coffeePrice = days * capsulesCount * pricePerCapsule;

            System.out.printf("The price for the coffee is: $%.2f%n", coffeePrice);

            totalCoffeePrice += coffeePrice;
        }
        System.out.printf("Total: $%.2f", totalCoffeePrice);
    }
}
