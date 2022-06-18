package FundamentalsMidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shelf = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Done")) {
            String[] commandLine = inputLine.split(" \\| ");
            String command = commandLine[0];


            switch (command) {
                case "Add Book":
                    String bookToAdd = commandLine[1];

                    if (shelf.contains(bookToAdd)) {
                        inputLine = scanner.nextLine();
                        continue;
                    }else {
                    shelf.add(0,bookToAdd);
                    }

                    break;
                case "Take Book":
                    String bookToTake = commandLine[1];

                    shelf.remove(bookToTake);

                    break;
                case "Swap Books":
                    String firstBookToSwap = commandLine[1];
                    String secondBookToSwap = commandLine[2];

                    if (shelf.contains(firstBookToSwap) && shelf.contains(secondBookToSwap)) {
                        int indexFirstBook = shelf.indexOf(firstBookToSwap);
                        int indexSecondBook = shelf.indexOf(secondBookToSwap);

                        Collections.swap(shelf, indexFirstBook, indexSecondBook);
                }else {
                        inputLine = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Insert Book":
                    String bookToInsert = commandLine[1];
                    if (shelf.contains(bookToInsert)) {
                        inputLine = scanner.nextLine();
                        continue;
                    }else {
                        shelf.add(bookToInsert);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt(commandLine[1]);

                    if (index >= 0 && index < shelf.size()){
                        System.out.println(shelf.get(index));
                    }else {
                        inputLine = scanner.nextLine();
                        continue;
                    }
                    break;

            }

            inputLine = scanner.nextLine();
        }
        System.out.println(String.join(", ", shelf));

    }
}
