package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String input = scanner.nextLine();
        String password = "";
        int countWrongPasswords = 0;

        for (int i = username.length() - 1; i >= 0; i--) {
           char symbol = username.charAt(i);
           password += symbol;
        }

        while (!input.equals(password)) {
            countWrongPasswords++;
            if (countWrongPasswords == 4){
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");



            input = scanner.nextLine();
        }

        if (input.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }

    }
}
