package Methods.Exercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isValidLength = isValidLengthOfPassword(password);
        if (!isValidLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean isValidContent = isPasswordConsistOnlyLettersAndDigits(password);
        if (!isValidContent) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean isValidCountOfDigits = isValidCountOfDigits(password);
        if (!isValidCountOfDigits) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength && isValidContent && isValidCountOfDigits) {
            System.out.println("Password is valid");
        }
    }

    public static boolean isValidLengthOfPassword(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        return false;
    }

    public static boolean isPasswordConsistOnlyLettersAndDigits(String password) {
        for (char symbol: password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCountOfDigits (String password) {
        int countDigits = 0;
        for (char symbol:password.toCharArray()) {
            if (Character.isDigit(symbol)){
                countDigits++;
            }
        }
        if (countDigits >= 2) {
            return true;
        }else {
            return false;
        }
    }
}

