package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> charOccurrences = new LinkedHashMap<>();

        for (char letter : input.toCharArray()) {

            if (letter == ' ') {
                continue;
            }
            if (!charOccurrences.containsKey(letter)) {
                charOccurrences.put(letter, 1);
            }else {
                int occurrences = charOccurrences.get(letter);
                charOccurrences.put(letter,occurrences + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry:charOccurrences.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
