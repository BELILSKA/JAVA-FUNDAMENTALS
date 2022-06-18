package TextProcessing.Exercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        StringBuilder text = new StringBuilder();

        for (char symbol : input) {
            text.append(String.format("%c", symbol + 3));
        }
        System.out.println(text);


    }
}
