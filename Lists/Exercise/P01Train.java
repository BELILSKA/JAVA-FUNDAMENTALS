package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            if (commandLine.get(0).equals("Add")) {
                wagons.add(Integer.parseInt(commandLine.get(1)));
            }else {
                int passengers = Integer.parseInt(commandLine.get(0));
                for (int i = 0; i < wagons.size(); i++) {
                    if (passengers + wagons.get(i) <= capacity) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }



            input = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
