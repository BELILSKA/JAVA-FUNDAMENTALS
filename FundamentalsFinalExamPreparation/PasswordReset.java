package FundamentalsFinalExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String [] data = input.split(":\\|:");
            String command = data[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(data[1]);
                    message.insert(index, " ");
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(data[1]);
                    if (message.toString().contains(substring)) {
                        int start = message.indexOf(substring.toString());
                        int end = start + substring.length() - 1;
                        message.delete(start, end + 1);
                        substring.reverse();
                        message.append(substring);
                    }else {
                        System.out.println("error");
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "ChangeAll":
                    String occurrence = data[1];
                    String replacement = data[2];

                  String replacedString = message.toString().replaceAll(occurrence, replacement);
                  message.setLength(0);
                  message.append(replacedString);
                    break;
            }

            System.out.println(message);

            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
