package Methods.MoreExercise;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();
        String input = scanner.nextLine();

        if (dataType.equals("int")) {
            int num = Integer.parseInt(input);
            getDataType(num);
        }else if (dataType.equals("real")) {
            double num = Double.parseDouble(input);
            getDataType(num);
        }else {
            getDataType(input);
        }
    }

    private static void getDataType(int num) {
        System.out.println(num * 2);
    }
    private static void getDataType (double num) {
        System.out.printf("%.2f", num * 1.5);
    }
    private static void getDataType (String text) {
        System.out.printf("$%s$",text);
    }

}
