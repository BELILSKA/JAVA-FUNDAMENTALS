package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char letter = scanner.nextLine().charAt(0);
            char decryptedLetter = (char) (letter + key);
            decryptedMessage.append(decryptedLetter);
        }
        System.out.println(decryptedMessage);
    }
}
