package FinalExam;

import java.util.Scanner;

public class P01DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Finish")) {
            String[] commandLine = input.split("\\s+");
            String command = commandLine[0];

            switch (command) {
                case "Replace":
                    String currentChar = commandLine[1];
                    String newChar = commandLine[2];

                    String replacedText = text.toString().replace(currentChar, newChar);
                    text.setLength(0);
                    text.append(replacedText);

                    System.out.println(text);

                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (startIndex >= 0 && startIndex < text.length() && endIndex >= 0 && endIndex < text.length()) {
                        text.delete(startIndex, endIndex + 1);
                        System.out.println(text);
                    } else {
                        System.out.println("Invalid indices!");
                    }

                    break;
                case "Make":
                    String upperOrLower = commandLine[1];

                    if (upperOrLower.equals("Upper")) {
                        for (int i = 0; i < text.length(); i++) {
                            char symbol = text.charAt(i);
                            symbol = Character.toUpperCase(symbol);
                            text = new StringBuilder(text.toString().replace(text.charAt(i), symbol));
                        }
                        System.out.println(text);
                    } else {
                        for (int i = 0; i < text.length(); i++) {
                            char symbol = text.charAt(i);
                            symbol = Character.toLowerCase(symbol);
                            text = new StringBuilder(text.toString().replace(text.charAt(i), symbol));
                        }
                        System.out.println(text);
                    }
                        break;
                        case "Check":
                            String string = commandLine[1];

                            if (text.toString().contains(string)) {
                                System.out.printf("Message contains %s%n",string);
                            }else {
                                System.out.printf("Message doesn't contain %s%n",string);
                            }
                            break;
                        case "Sum":
                            int startInd = Integer.parseInt(commandLine[1]);
                            int endInd = Integer.parseInt(commandLine[2]);

                            if (startInd >= 0 && startInd < text.length() && endInd >= 0 && endInd < text.length()) {
                             String substring = text.toString().substring(startInd, endInd +1);

                                int sum = 0;
                                for (int i = startInd; i <= endInd; i++) {
                                    int currentDigit = text.charAt(i);
                                    sum += currentDigit;
                                }
                                System.out.println(sum);
                            }else {
                                System.out.println("Invalid indices!");
                            }

                            break;
                    }


                    input = scanner.nextLine();
            }

        }
    }

