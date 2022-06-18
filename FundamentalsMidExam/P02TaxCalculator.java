package FundamentalsMidExam;

import java.util.Scanner;

public class P02TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicles = scanner.nextLine().split(">>");

        double taxForEveryCars = 0;

        for (int i = 0; i < vehicles.length; i++) {
            String[] dataForEveryCar = vehicles[i].split(" ");
            String carType = dataForEveryCar[0];
            int years = Integer.parseInt(dataForEveryCar[1]);
            int kilometers = Integer.parseInt(dataForEveryCar[2]);

            int initialTax = 0;
            double totalTax = 0;
            switch (carType) {
                case "family":
                    initialTax = 50;

                    totalTax = Math.floor(kilometers / 3000.0) * 12 + (initialTax - years * 5);

                    break;
                case "heavyDuty":
                    initialTax = 80;

                    totalTax = Math.floor(kilometers / 9000.0) * 14 + (initialTax - years * 8);

                    break;
                case "sports":
                    initialTax = 100;

                    totalTax = Math.floor(kilometers / 2000.0) * 18 + (initialTax - years * 9);

                    break;
                default:
                    System.out.println("Invalid car type.");
                    continue;

            }
            taxForEveryCars += totalTax;
            System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, totalTax);

        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.",taxForEveryCars);

    }
}
