package Arrays.Exercise;

import java.util.Scanner;
import java.util.Arrays;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayNumbers = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arrayNumbers.length; i++) {
            for (int j = i + 1; j < arrayNumbers.length; j++) {
                if (arrayNumbers[i] + arrayNumbers[j] == number) {
                    System.out.println(arrayNumbers[i] + " " + arrayNumbers[j]);
                }
            }
        }
    }
}
