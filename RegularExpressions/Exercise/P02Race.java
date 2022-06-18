package RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", "))
                        .collect(Collectors.toList());

        Pattern namePattern = Pattern.compile("[A-Za-z]");
        Pattern distancePattern = Pattern.compile("[\\d]");
        Map<String, Integer> dataParticipants = new LinkedHashMap<>();

        for (String participant:participants) {
            dataParticipants.putIfAbsent(participant, 0);
        }

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder name = new StringBuilder();

            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }

            if (dataParticipants.containsKey(name.toString())) {
                Matcher distanceMatcher = distancePattern.matcher(input);
                int sum = 0;
                while (distanceMatcher.find()) {
                   int digit = Integer.parseInt(distanceMatcher.group());
                   sum += digit;
                   }
                   dataParticipants.put(name.toString(), dataParticipants.get(name.toString()) + sum);
                }

            input = scanner.nextLine();

            }
            List<String> sorted = dataParticipants.entrySet().stream()
                    .sorted((a,b)-> Integer.compare(b.getValue(), a.getValue()))
                    .map(Map.Entry::getKey).collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            String text = "";
            if (i == 0) {
                text = "st";
            }else if (i == 1) {
                text = "nd";
            }else if (i == 2) {
                text = "rd";
            }else {
                break;
            }
            System.out.printf("%d%s place: %s%n", i + 1, text, sorted.get(i));

        }


        }
    }
