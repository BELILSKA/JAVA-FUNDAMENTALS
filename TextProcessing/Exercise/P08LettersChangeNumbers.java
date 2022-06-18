package TextProcessing.Exercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double sum = 0;
        for (String s : input) {
            char letterBefore = s.charAt(0);
            char letterAfter = s.charAt(s.length() - 1);
            String digits = s.substring(1,s.length() - 1);
            double number = Double.parseDouble(digits);

            if (Character.isUpperCase(letterBefore)) {
                sum += number / positionInAlphabet(letterBefore);
            }else {
                sum += number * positionInAlphabet(letterBefore);
            }

            if (Character.isUpperCase(letterAfter)) {
                sum -= positionInAlphabet(letterAfter);
            }else {
                sum += positionInAlphabet(letterAfter);
            }

        }
        System.out.printf("%.2f", sum);
    }
    static int positionInAlphabet (char letter) {
        return Character.toLowerCase(letter) - 96;
    }
}
