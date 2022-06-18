package ProgrammingFundamentalsExams;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] commandLine = input.split("\\|");
            String command = commandLine[0];

            switch (command) {
                case "Move":
                    int numOfLetters = Integer.parseInt(commandLine[1]);

                    //Moves the first n letters to the back of the string

                    String toRemove = message.substring(0, numOfLetters);
                    message.delete(0, numOfLetters);
                    message.append(toRemove);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLine[1]);
                    String value = commandLine[2];

                    //Inserts the given value before the given index in the string

                    message.insert(index, value);


                    break;
                case "ChangeAll":
                    String substring = commandLine[1];
                    String replacement = commandLine[2];

                    //Changes all occurrences of the given substring with the replacement text

                 String changedMessage = message.toString().replace(substring,replacement);
                 message.setLength(0);
                 message.append(changedMessage);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", message);

    }
}
