package Lists.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());


       StringBuilder text = new StringBuilder(scanner.nextLine());
       StringBuilder message = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            int element = numbers.get(i);
            int index = getSum(element);

            if (index >= text.length()) {
                index = index - text.length();
            }
            char symbol = text.charAt(index);
            text.deleteCharAt(index);
            message.append(symbol);
        }
        System.out.println(message);
    }

    private static int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
