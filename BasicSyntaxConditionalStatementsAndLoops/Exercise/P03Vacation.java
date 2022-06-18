package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        String typeGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double singlePersonPrice = 0;

        switch (typeGroup) {
            case "Students":
                if (dayOfWeek.equals("Friday")) {
                    singlePersonPrice = 8.45;
                }else if (dayOfWeek.equals("Saturday")) {
                    singlePersonPrice = 9.80;
                }else if (dayOfWeek.equals("Sunday")) {
                    singlePersonPrice = 10.46;
                }
                break;
            case "Business":
                if (dayOfWeek.equals("Friday")) {
                    singlePersonPrice = 10.90;
                }else if (dayOfWeek.equals("Saturday")) {
                    singlePersonPrice = 15.60;
                }else if (dayOfWeek.equals("Sunday")) {
                    singlePersonPrice = 16;
                }
                break;
            case "Regular":
                if (dayOfWeek.equals("Friday")) {
                    singlePersonPrice = 15;
                }else if (dayOfWeek.equals("Saturday")) {
                    singlePersonPrice = 20;
                }else if (dayOfWeek.equals("Sunday")) {
                    singlePersonPrice = 22.50;
                }
                break;
        }
        double totalPrice = countPeople * singlePersonPrice;

        if (typeGroup.equals("Students") && countPeople >= 30) {
            totalPrice = totalPrice * 0.85;
        }
        if (typeGroup.equals("Business") && countPeople >= 100) {
            totalPrice = totalPrice - (10 * singlePersonPrice);
        }
        if (typeGroup.equals("Regular") && countPeople >= 10 && countPeople <= 20) {
            totalPrice = totalPrice * 0.95;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
