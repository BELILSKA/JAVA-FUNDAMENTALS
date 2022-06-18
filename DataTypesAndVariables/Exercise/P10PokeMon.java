package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int countPokes = 0;
        int currentPokePower = N;

        while (currentPokePower >= M) {
            currentPokePower -= M;
            countPokes++;

            if (currentPokePower == N / 2.0 && Y != 0) {
                currentPokePower = currentPokePower / Y;
            }

        }
        System.out.println(currentPokePower);
        System.out.println(countPokes);
    }
}
