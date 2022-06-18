package Methods.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printCountOfVowels(text);

    }

    public static void printCountOfVowels (String text) {

        int countVowels = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
                if (currentSymbol == 'A' || currentSymbol == 'a' || currentSymbol == 'E' || currentSymbol == 'e'
                || currentSymbol == 'I' || currentSymbol == 'i' || currentSymbol == 'O' || currentSymbol == 'o' ||
                currentSymbol == 'U' || currentSymbol == 'u') {
                    countVowels++;
                }
        }
        System.out.println(countVowels);
    }
}
