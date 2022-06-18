package Lists.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSetQuality = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> initialQuality = new ArrayList<>(drumSetQuality);

        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);

            for (int i = 0; i < drumSetQuality.size(); i++) {
                drumSetQuality.set(i, drumSetQuality.get(i) - hitPower);
            }

            for (int i = 0; i < drumSetQuality.size(); i++) {

                if (drumSetQuality.get(i) <= 0) {

                    if (savings - (initialQuality.get(i) * 3) > 0) {
                        drumSetQuality.set(i, initialQuality.get(i));
                        savings -= (initialQuality.get(i) * 3);
                    } else {
                        drumSetQuality.remove(i);
                        initialQuality.remove(i);
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int element : drumSetQuality) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);

    }
}
