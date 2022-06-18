package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03LegendaryFarming2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        String winner = "";
        boolean hasWinner = false;

        while (!hasWinner) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < input.length - 1; i += 2) {
                String material = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);

                if (!materials.containsKey(material)) {
                    materials.put(material, quantity);
                } else {
                    int currentQuantity = materials.get(material);
                    materials.put(material, currentQuantity + quantity);
                }
                if (material.equals("shards") || material.equals("fragments") ||
                        material.equals("motes")) {
                    if (materials.get(material) >= 250) {
                        materials.put(material, materials.get(material) - 250);
                        winner = material;
                        hasWinner = true;
                        break;
                    }
                }

            }
        }
        switch (winner) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
        materials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }
}






