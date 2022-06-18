package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());

        String input = scanner.nextLine();
        double totalSpentMoney = 0;

        while (!input.equals("Game Time")) {
            String game = input;
            double price = 0;


            switch (game) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    input = scanner.nextLine();
                    continue;
            }

            if (currentBalance >= price) {
                currentBalance = currentBalance - price;
                totalSpentMoney += price;
                System.out.printf("Bought %s%n", game);
            }else {
                System.out.println("Too Expensive");
            }

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }



            input = scanner.nextLine();
        }
        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f%n",totalSpentMoney,currentBalance);
        }
    }
}
