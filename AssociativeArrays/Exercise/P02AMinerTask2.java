package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Integer> resourcesMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourcesMap.containsKey(resource)) {
                resourcesMap.put(resource, quantity);
            }else {
                int currentQuantity = resourcesMap.get(resource);
                resourcesMap.put(resource,currentQuantity + quantity);
            }
            input = scanner.nextLine();

        }
        for (Map.Entry<String,Integer> entry:resourcesMap.entrySet()){
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
