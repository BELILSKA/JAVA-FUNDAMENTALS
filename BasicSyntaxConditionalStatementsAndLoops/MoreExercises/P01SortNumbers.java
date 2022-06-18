package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            numbers.add(num);
        }
        numbers.stream().sorted((n1,n2)-> Integer.compare(n2,n1)).forEach(System.out::println);
    }
}
