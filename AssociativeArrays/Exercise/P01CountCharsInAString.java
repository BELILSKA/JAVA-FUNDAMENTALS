package AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textArr = scanner.nextLine().split(" ");

        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        for (String text : textArr) {
            for (int i = 0; i < text.length(); i++) {
                char symbol = text.charAt(i);
                if (!charCountMap.containsKey(symbol)) {
                    charCountMap.put(symbol, 1);
                }else {
                    charCountMap.put(symbol, charCountMap.get(symbol) + 1);
                }
            }
        }


        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
