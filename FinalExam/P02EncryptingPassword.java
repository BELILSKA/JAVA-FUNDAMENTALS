package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("([!-}]+)>(?<numbers>[0-9]{3})\\|(?<letters>[a-z]{3})\\|(?<capitalLetters>[A-Z]{3})\\|(?<symbols>[^><]{3})<\\1");

        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);
            StringBuilder encryptedPassword = new StringBuilder();

            if (matcher.find()) {
                encryptedPassword.append(matcher.group("numbers"));
                encryptedPassword.append(matcher.group("letters"));
                encryptedPassword.append(matcher.group("capitalLetters"));
                encryptedPassword.append(matcher.group("symbols"));

                System.out.printf("Password: %s%n",encryptedPassword);
            }else {
                System.out.println("Try another password!");
            }


        }
    }
}
