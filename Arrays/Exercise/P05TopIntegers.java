package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 1 4 3 2
        int topIntegers = 0;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];

            if (i == array.length - 1) {
                System.out.print(currentNumber + " ");
                continue;

            }

            boolean isTop = false;
            for (int j = i + 1; j < array.length; j++) {
                if (currentNumber > array[j]) {
                    isTop = true;
                }else {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
