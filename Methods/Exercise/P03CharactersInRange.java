package Methods.Exercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);

        printCharactersBetweenGivenTwo(firstSymbol, secondSymbol);


    }

    public static void printCharactersBetweenGivenTwo(char firstSymbol, char secondSymbol) {

        if (firstSymbol < secondSymbol) {
            for (int i = firstSymbol + 1; i < secondSymbol; i++) {
                System.out.print((char) i + " ");
            }
        }else {
            for (int i = secondSymbol + 1; i < firstSymbol; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}
