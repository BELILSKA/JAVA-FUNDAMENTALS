package RegularExpressions.Exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern keyPattern = Pattern.compile("[starSTAR]");
        Pattern messagePattern = Pattern.compile("^[^@\\-!:>]*@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>[\\d]+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>\\d+)[^@\\-!:>]*$");

        List<String> attacked = new LinkedList<>();
        List<String> destroyed = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String encryptedMessage = scanner.nextLine();
            Matcher keyMatcher = keyPattern.matcher(encryptedMessage);

            int count = 0;
            while (keyMatcher.find()) {
                count++;
            }

            StringBuilder sb = new StringBuilder(encryptedMessage);
            for (int j = 0; j < sb.length(); j++) {
                int newChar = sb.charAt(j) - count;
                sb.setCharAt(j, (char) newChar);
            }

            Matcher messageMatcher = messagePattern.matcher(sb.toString());

            if (messageMatcher.find()) {
                String planetName = messageMatcher.group("planet");
                String population = messageMatcher.group("population");
                String attackType = messageMatcher.group("attackType");
                String soldierCount = messageMatcher.group("soldierCount");

                if (attackType.equals("A")) {
                    attacked.add(planetName);
                } else {
                    destroyed.add(planetName);
                }
            }


        }
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.stream().sorted(String::compareTo).forEach(p -> System.out.printf("-> %s%n", p));

        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.stream().sorted(String::compareTo).forEach(p -> System.out.printf("-> %s%n", p));
    }
}
