package ProgrammingFundamentalsExams;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeStudents = Integer.parseInt(scanner.nextLine());
        int secondEmployeeStudents = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeStudents = Integer.parseInt(scanner.nextLine());
        int allStudentsCount = Integer.parseInt(scanner.nextLine());
        int hours = 0;

        while (allStudentsCount > 0) {
            hours++;

            if (hours % 4 == 0) {
                continue;
            }
        int answeredStudentsForHour = firstEmployeeStudents + secondEmployeeStudents + thirdEmployeeStudents;
        allStudentsCount -= answeredStudentsForHour;


        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
