package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> resourceMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceMap.containsKey(resource)) {
                resourceMap.put(resource, quantity);
            }else {
                resourceMap.put(resource, resourceMap.get(resource) + quantity);
            }

            input = scanner.nextLine();
        }
        resourceMap.forEach((key,value) -> System.out.printf("%s -> %d%n", key,value));
    }
}
