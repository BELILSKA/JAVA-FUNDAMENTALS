package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,String> registerMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];
            String username = commandLine[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = commandLine[2];

                    if (registerMap.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n",licensePlateNumber);
                    }else {
                        registerMap.put(username,licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n",username,licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!registerMap.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n",username);
                    }else {
                        registerMap.remove(username);
                        System.out.printf("%s unregistered successfully%n",username);
                    }
                    break;
            }
        }
        registerMap.forEach((key, value)-> System.out.printf("%s => %s%n",key, value));
    }
}
