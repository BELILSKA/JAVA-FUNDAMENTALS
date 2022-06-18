package FinalExam;

import java.util.*;

public class P03DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> likedMeals = new LinkedHashMap<>();
        int countDislikedMeals = 0;

        while (!input.equals("Stop")) {
            String[] commandLine = input.split("-");
            String command = commandLine[0];
            String guest = commandLine[1];
            String meal = commandLine[2];

            switch (command) {
                case "Like":
                    if (!likedMeals.containsKey(guest)) {
                    likedMeals.put(guest, new ArrayList<>());
                    likedMeals.get(guest).add(meal);
                    }else {
                        if (!likedMeals.get(guest).contains(meal)) {
                            likedMeals.get(guest).add(meal);
                        }
                    }

                    break;
                case "Dislike":
                    if (!likedMeals.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                        input = scanner.nextLine();
                        continue;
                    }

                    if (likedMeals.get(guest).contains(meal)) {
                        likedMeals.get(guest).remove(meal);
                        System.out.printf("%s doesn't like the %s.%n",guest,meal);
                        countDislikedMeals++;
                    }else {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n",guest, meal);
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : likedMeals.entrySet()) {
            System.out.printf("%s: ",entry.getKey());
            System.out.println(String.join(", ", entry.getValue()));
        }
        System.out.printf("Unliked meals: %d",countDislikedMeals);

    }
}
