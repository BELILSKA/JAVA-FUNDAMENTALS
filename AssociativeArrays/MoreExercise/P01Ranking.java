package AssociativeArrays.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,String> contests = new LinkedHashMap<>();
        Map<String,Map<String,Integer>> usersData = new TreeMap<>();

        while (!input.equals("end of contests")) {
            String[] contestData = input.split(":");
            String contest = contestData[0];
            String password = contestData[1];

            contests.put(contest,password);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            String[] submissionsData = input.split("=>");
            String contest = submissionsData[0];
            String password = submissionsData[1];
            String username = submissionsData[2];
            int points = Integer.parseInt(submissionsData[3]);

            if (isValidContest(contest,contests) && isValidPassword(password,contest,contests)) {

                if (!usersData.containsKey(username)) {
                    usersData.put(username,new LinkedHashMap<>());
                    usersData.get(username).put(contest,points);
                }else if (usersData.containsKey(username)) {
                    if (usersData.get(username).containsKey(contest)) {
                        int currentPoints = usersData.get(username).get(contest);

                        if (points > currentPoints) {
                            usersData.get(username).put(contest,points);
                        }
                    }else {
                        usersData.get(username).put(contest,points);
                    }
                }
            }


            input = scanner.nextLine();
        }
        String bestCandidate = "";
        int maxPoints = 0;

        for (Map.Entry<String, Map<String, Integer>> entry : usersData.entrySet()) {
            int totalPoints = entry.getValue().values().stream().mapToInt(i -> i).sum();

            if(totalPoints > maxPoints) {
                maxPoints = totalPoints;
                bestCandidate = entry.getKey();
            }

        }
        System.out.printf("Best candidate is %s with total %d points.%n",bestCandidate,maxPoints);
        System.out.println("Ranking: ");
        for (Map.Entry<String,Map<String, Integer>> entry : usersData.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream()
                    .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                    .forEach(k -> System.out.println("#  "+ k.getKey() + " -> " + k.getValue()));
        }


    }

    private static boolean isValidPassword(String password, String contest, Map<String, String> contests) {
        if (contests.containsKey(contest)) {
            if (contests.get(contest).equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidContest(String contest, Map<String, String> contests) {
        if (contests.containsKey(contest)) {
            return true;
        }
        return false;
    }
}
