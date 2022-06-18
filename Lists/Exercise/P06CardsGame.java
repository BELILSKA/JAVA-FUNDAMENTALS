package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {
            int currentCardFirstPlayer = firstPlayerCards.get(0);
            int currentCardSecondPlayer = secondPlayerCards.get(0);

            if (currentCardFirstPlayer > currentCardSecondPlayer) {
                firstPlayerCards.add(currentCardFirstPlayer);
                firstPlayerCards.add(currentCardSecondPlayer);
            }else if (currentCardSecondPlayer > currentCardFirstPlayer) {
                secondPlayerCards.add(currentCardSecondPlayer);
                secondPlayerCards.add(currentCardFirstPlayer);
            }
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);
        }

        if (secondPlayerCards.isEmpty()) {
            System.out.printf("First player wins! Sum: %d",getSum(firstPlayerCards));
        }else {
            System.out.printf("Second player wins! Sum: %d",getSum(secondPlayerCards));
        }

    }
    public static int getSum (List<Integer> listCards) {
        int sum = 0;
        for (int card:listCards) {
            sum+=card;
        }
        return sum;
    }
}
