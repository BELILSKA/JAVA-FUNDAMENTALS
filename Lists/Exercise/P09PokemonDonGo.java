package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDonGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int sum = 0;
        while (!numbers.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int lastNumber = numbers.get(numbers.size() - 1);
            int firstNumber = numbers.get(0);
            int numberToRemove = 0;

            if (index < 0) {
                numberToRemove = numbers.get(0);
                numbers.remove(0);
                numbers.add(0,lastNumber);
            }else if (index >= numbers.size()) {
                numberToRemove = numbers.get(numbers.size() - 1);
                numbers.remove(numbers.size()-1);
                numbers.add(firstNumber);
            }else {
                numberToRemove = numbers.get(index);
                numbers.remove(index);
            }
            sum += numberToRemove;
            for (int i = 0; i < numbers.size(); i++) {
                int number = numbers.get(i);
                if (number <= numberToRemove) {
                    number = number + numberToRemove;
                }else {
                    number = number - numberToRemove;
                }
                numbers.set(i, number);
            }
        }
        System.out.println(sum);
    }
}
