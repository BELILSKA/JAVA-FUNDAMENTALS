package ProgrammingFundamentalsExams;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalPriceWithoutTax = 0;
        while (!input.equals("special") && !input.equals("regular")) {
            double priceWithoutTax = Double.parseDouble(input);

            if (priceWithoutTax < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }

            totalPriceWithoutTax += priceWithoutTax;


            input = scanner.nextLine();
        }

        double sumTax = totalPriceWithoutTax * 0.2;
        double totalPrice = totalPriceWithoutTax + sumTax;

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        }
        if (input.equals("special")) {
            totalPrice = totalPrice * 0.9;
        }

        if (totalPrice != 0) {
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTax);
        System.out.printf("Taxes: %.2f$%n", sumTax);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$", totalPrice);

        }

        }


    }

