package Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < countCommands; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            String name = data[0];

            if (!input.contains("is not going!")) {
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!%n",name);
                }else {
                    guests.add(name);
                }
            }else {
                if (guests.contains(name)) {
                    guests.remove(name);
                }else {
                    System.out.printf("%s is not in the list!%n", name);
                }

            }
        }
        guests.forEach(System.out::println);

    }
}
