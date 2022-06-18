package FundamentalsFinalExamPreparation;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        char symbol = password.charAt(i);
                       newPassword.append(symbol);
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandLine[1]);
                    int length = Integer.parseInt(commandLine[2]);

                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = commandLine[1];
                    String substitute = commandLine[2];

                    if (password.toString().contains(substring)) {
                       String replacedPassword = password.toString().replaceAll(substring, substitute);
                       password.setLength(0);
                       password.append(replacedPassword);
                       System.out.println(password);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s",password);
    }
}
