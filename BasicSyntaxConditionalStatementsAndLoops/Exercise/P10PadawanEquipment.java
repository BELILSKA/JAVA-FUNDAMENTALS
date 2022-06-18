package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double availableAmount = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceForSingleSaber = Double.parseDouble(scanner.nextLine());
        double priceOfSingleRobe = Double.parseDouble(scanner.nextLine());
        double priceOfSingleBelt = Double.parseDouble(scanner.nextLine());


        double neededSabers = Math.ceil(countStudents * 1.10);
        double neededBelts = countStudents - Math.floor(countStudents / 6.0);

        double totalPrice = (neededSabers * priceForSingleSaber) + (countStudents * priceOfSingleRobe) +
                (neededBelts * priceOfSingleBelt);


        if (availableAmount >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalPrice);
        }else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - availableAmount);
        }

    }
}
