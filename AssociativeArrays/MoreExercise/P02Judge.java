package AssociativeArrays.MoreExercises;

import java.util.*;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, TreeMap<String, Integer>> contestsMap = new LinkedHashMap<>();
        Map<String, Integer> individualResults = new LinkedHashMap<>();

        while (!input.equals("no more time")) {
            String[] data = input.split(" -> ");
            String username = data[0];
            String contest = data[1];
            int points = Integer.parseInt(data[2]);
            boolean haveNewPoints = false;

            if(!contestsMap.containsKey(contest)) {
                contestsMap.put(contest, new TreeMap<>());
                contestsMap.get(contest).put(username,points);
            }else {
              if(!isStudentExist(username,contest,contestsMap)) {
                  contestsMap.get(contest).put(username,points);
              }else {
                  int currentPoints = contestsMap.get(contest).get(username);

                  if (currentPoints < points) {
                      contestsMap.get(contest).put(username,points);
                      haveNewPoints = true;

                  }else {
                      input = scanner.nextLine();
                      continue;
                  }
              }
            }

            if (!individualResults.containsKey(username)) {
                individualResults.put(username,points);
            }else if (haveNewPoints){
                individualResults.put(username,points);
            }else {
                int currentPoints = individualResults.get(username);
                individualResults.put(username,currentPoints + points);
            }



            input = scanner.nextLine();
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestsMap.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());

            int[] order = {0};

            entry.getValue().entrySet()
                    .stream()
                    .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                    .forEach(result -> {
                        order[0]++;
                        System.out.printf("%d. %s <::> %d%n", order[0], result.getKey(), result.getValue());
                    });


        }
        System.out.println("Individual standings:");
        int[] counter = {0};
        individualResults.entrySet()
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .forEach(result -> {
                    counter[0]++;
                    System.out.printf("%d. %s -> %d%n", counter[0], result.getKey(), result.getValue());
                });

    }

    private static boolean isStudentExist(String username, String contest, Map<String, TreeMap<String, Integer>> contestsMap) {
        if(contestsMap.containsKey(contest)) {
            if(contestsMap.get(contest).containsKey(username)) {
                return true;
            }
        }
        return false;
    }
}

