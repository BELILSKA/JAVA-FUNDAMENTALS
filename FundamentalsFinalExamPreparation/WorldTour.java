package FundamentalsFinalExamPreparation;

import javax.swing.*;
import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] commandLine = input.split(":");
            String command = commandLine[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(commandLine[1]);
                    String string = commandLine[2];

                    if (index < stops.length() && index >= 0) {
                        stops.insert(index, string);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
                        stops.replace(startIndex, endIndex + 1, "");
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = commandLine[1];
                    String newString = commandLine[2];

                    if (stops.toString().contains(oldString)) {
                        String replaced = stops.toString().replace(oldString, newString);
                        stops.setLength(0);
                        stops.append(replaced);
                    }
                    System.out.println(stops);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }
}
