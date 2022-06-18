package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalSumCoins = 0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);

            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
            totalSumCoins += coins;
            }else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }


            input = scanner.nextLine();
        }

       input = scanner.nextLine();

        while (!input.equals("End")) {
            String product = input;
            double priceProduct = 0;

            if (product.equals("Nuts")) {
                priceProduct = 2.0;
            }else if (product.equals("Water")) {
                priceProduct = 0.7;
            }else if (product.equals("Crisps")) {
                priceProduct = 1.50;
            }else if (product.equals("Soda")) {
                priceProduct = 0.8;
            }else if (product.equals("Coke")) {
                priceProduct = 1.0;
            }else {
                System.out.println("Invalid product");
                input = scanner.nextLine();
                continue;
            }

            if (priceProduct > totalSumCoins){
                System.out.println("Sorry, not enough money");
                input = scanner.nextLine();
                continue;
            }

            System.out.printf("Purchased %s%n", product);
            totalSumCoins -= priceProduct;



            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalSumCoins);
    }
}
