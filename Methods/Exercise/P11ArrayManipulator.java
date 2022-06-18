package Methods.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String [] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(data[1]);
                    if (isvalidIndex(index, numArray.length)) {
                        exchange(numArray, index);
                    }else {
                        System.out.println("Invalid Index");
                    }
                    break;
                case "max":
                    if (data[1].equals("even")) {

                    }else {

                    }
                    break;
                case "min":
                    if (data[1].equals("even")) {

                    }else {

                    }
                    break;
                case "first":
                    if (data[2].equals("even")) {

                    }else {

                    }
                    break;
                case "last":
                    if (data[2].equals("even")) {

                    }else {

                    }
                    break;
            }


            input = scanner.nextLine();
        }
    }

    private static boolean isvalidIndex(int index, int length) {
        return index >= 0 && index < length;
    }

    private static void exchange(int[] numArray, int index) {
        int [] first = new int[index + 1];
        int[] second = new int[numArray.length - index - 1];

        for (int i = 0; i <= index; i++) {
            first[i] = numArray[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = numArray[index + 1 + i];
        }
        for (int i = 0; i < numArray.length; i++) {
            if (i < second.length) {
                numArray[i] = second[i];
            }else {
                numArray[i] = first[i - second.length];
            }
        }
    }

}
