package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int litersInTheTank = 0;

        for (int i = 1; i <= n; i++) {
            int quantityWater = Integer.parseInt(scanner.nextLine());

            if (litersInTheTank + quantityWater > 255) {
                System.out.println("Insufficient capacity!");
                continue;
            }

            litersInTheTank += quantityWater;

        }
        System.out.println(litersInTheTank);
    }
}
