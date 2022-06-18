package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class P02EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int lastDigit = num % 10;
        String nameDigit = "";
        if (lastDigit == 0) {
           nameDigit = "zero";
        }else if (lastDigit == 1) {
            nameDigit = "one";
        }else if (lastDigit == 2) {
            nameDigit = "two";
        }else if (lastDigit == 3) {
            nameDigit = "three";
        }else if (lastDigit == 4) {
            nameDigit = "four";
        }else if (lastDigit == 5) {
            nameDigit = "five";
        }else if (lastDigit == 6) {
            nameDigit = "six";
        }else if (lastDigit == 7) {
            nameDigit = "seven";
        }else if (lastDigit == 8) {
            nameDigit = "eight";
        }else if (lastDigit == 9) {
            nameDigit = "nine";
        }
        System.out.println(nameDigit);

    }
}
