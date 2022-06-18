package FundamentalsMidExam;

import java.util.Scanner;

public class P01TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsProducesPerDay = Integer.parseInt(scanner.nextLine());
        int countWorkers = Integer.parseInt(scanner.nextLine());
        int biscuitsCompetingFactoryProducesFor30days = Integer.parseInt(scanner.nextLine());

        int totalBiscuitsPerDay = biscuitsProducesPerDay * countWorkers;


        double totalBiscuits = (20 * totalBiscuitsPerDay) + (10 * Math.floor(totalBiscuitsPerDay * 0.75));
        double diff = Math.abs(totalBiscuits - biscuitsCompetingFactoryProducesFor30days);

        System.out.printf("You have produced %.0f biscuits for the past month.%n", totalBiscuits);

        if (totalBiscuits > biscuitsCompetingFactoryProducesFor30days) {
            System.out.printf("You produce %.2f percent more biscuits.", diff/biscuitsCompetingFactoryProducesFor30days * 100);
        }else {
            System.out.printf("You produce %.2f percent less biscuits.", diff/biscuitsCompetingFactoryProducesFor30days * 100);
        }





    }
}
