package Methods.MoreExercise;

import java.util.Scanner;

public class P02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X1 = Integer.parseInt(scanner.nextLine());
        int Y1 = Integer.parseInt(scanner.nextLine());
        int X2 = Integer.parseInt(scanner.nextLine());
        int Y2 = Integer.parseInt(scanner.nextLine());
        
        printTheClosestPoint(X1,Y1,X2,Y2);
    }

    private static void printTheClosestPoint(int X1,int Y1,int X2, int Y2) {
        int closestX = 0;
        int closestY = 0;

        int firstPoint = Math.abs(X1) + Math.abs(Y1);
        int secondPoint = Math.abs(X2) + Math.abs(Y2);

        if (firstPoint <= secondPoint) {
            closestX = X1;
            closestY = Y1;
        }else {
            closestX = X2;
            closestY = Y2;
        }

        System.out.printf("(%d, %d)", closestX,closestY);
    }
}
