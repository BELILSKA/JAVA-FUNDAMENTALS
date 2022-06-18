package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
           String input = scanner.nextLine();

           if (input.equals("0")) {
               System.out.print(" ");
               continue;
           }
           int digitsLength = input.length();
           int mainDigit = Integer.parseInt(String.valueOf(input.charAt(0)));
           int offsetOfNumber = (mainDigit - 2) * 3;

           if (mainDigit == 8 || mainDigit == 9) {
               offsetOfNumber = offsetOfNumber + 1;
           }

           int letterIndex = (offsetOfNumber + digitsLength - 1) + 97;

          char letter = (char) letterIndex;
            System.out.print(letter);
        }

    }
}
