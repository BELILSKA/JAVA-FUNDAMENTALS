package FundamentalsFinalExamPreparation;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantsData = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantsInfo = scanner.nextLine().split("<->");
            String plant = plantsInfo[0];
            double rarity = Double.parseDouble(plantsInfo[1]);

            plantsData.put(plant, new ArrayList<>());
            plantsData.get(plant).add(0, rarity);
            plantsData.get(plant).add(1, 0.0);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] commandLine = input.split("[: ][\\s\\- ]");
            String command = commandLine[0];
            String plantName = commandLine[1];

            if (!plantsData.containsKey(plantName)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(commandLine[2]);
                    if (plantsData.get(plantName).get(1) == 0) {
                    plantsData.get(plantName).add(1, rating);
                    }else {
                        double newRate = (plantsData.get(plantName).get(1) + rating) / 2;
                        plantsData.get(plantName).set(1, newRate);
                    }
                    break;
                case "Update":
                    double newRarity = Double.parseDouble(commandLine[2]);

                    plantsData.get(plantName).set(0, newRarity);
                    break;
                case "Reset":
                    plantsData.get(plantName).set(1, 0.0);
                    break;
            }


            input = scanner.nextLine();
        }
       System.out.println("Plants for the exhibition:");
       plantsData.forEach((k,v)-> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", k, v.get(0), v.get(1)));


    }
}
