package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);
            int element = Integer.parseInt(commandLine.get(1));

            switch (command) {
                case "Delete":

                    while (numList.contains(element)) {
                        numList.remove(Integer.valueOf(element));
                    }
                    break;
                case "Insert":
                    int position = Integer.parseInt(commandLine.get(2));

                    numList.add(position, element);

                    break;
            }



            input = scanner.nextLine();
        }
        numList.forEach(el -> System.out.print(el + " "));
    }


    }

