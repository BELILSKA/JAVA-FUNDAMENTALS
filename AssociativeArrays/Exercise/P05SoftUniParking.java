package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingRegister = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];


            switch (command) {
                case "register":
                    String newUser = data[1];
                    String plateNumber = data[2];
                    if (parkingRegister.containsKey(newUser)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                    }else {
                        parkingRegister.put(newUser, plateNumber);
                        System.out.printf("%s registered %s successfully%n", newUser, plateNumber);
                    }
                    break;
                case "unregister":
                    String username = data[1];
                    if(!parkingRegister.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }else {
                        parkingRegister.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }


        }
        parkingRegister.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}
