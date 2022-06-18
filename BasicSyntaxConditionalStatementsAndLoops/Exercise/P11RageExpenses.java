package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double trashedHeadsets = Math.floor(lostGamesCount / 2.0);
        double trashedMises = Math.floor(lostGamesCount / 3.0);
        double trashedKeyboards = Math.floor(lostGamesCount / 6.00);
        double trashedDisplays = Math.floor(trashedKeyboards / 2);

        double expenses = (trashedHeadsets * headsetPrice) + (trashedMises * mousePrice) +
                (trashedKeyboards * keyboardPrice) + (trashedDisplays * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
