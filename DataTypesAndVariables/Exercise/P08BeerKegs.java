package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxVolume = 0;
        String maxModel = "";

        for (int i = 1; i <= n ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

//            π * r^2 * h

           double currentVolume = Math.PI * Math.pow(radius,2) * height;

            if (currentVolume > maxVolume) {
                maxVolume = currentVolume;
                maxModel = model;
           }

        }
        System.out.println(maxModel);
    }
}
