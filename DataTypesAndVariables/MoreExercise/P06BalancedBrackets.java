package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int openCount = 0;
        int closeCount = 0;

        for (int i = 1; i <= n ; i++) {
            String symbol = scanner.nextLine();

            if (symbol.equals("(")) {
                openCount++;
            }else if (symbol.equals(")")) {
                closeCount++;
            }
        }
        if (openCount == closeCount) {
            System.out.println("BALANCED");
        }else {
            System.out.println("UNBALANCED");
        }

    }
}
