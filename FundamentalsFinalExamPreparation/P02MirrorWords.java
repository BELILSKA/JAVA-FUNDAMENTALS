package FundamentalsFinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("(@|#)(?<firstWord>[a-zA-z]{3,})\\1{2}(?<secWord>[a-zA-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> mirrorWords = new ArrayList<>();
        int count = 0;
        while (matcher.find()) {
            count ++;
            StringBuilder firstWord = new StringBuilder(matcher.group("firstWord"));
            StringBuilder secWord = new StringBuilder(matcher.group("secWord"));
            if(firstWord.reverse().compareTo(secWord)==0) {
                firstWord.reverse().append(" <=> ").append(secWord);
                mirrorWords.add(firstWord.toString());
            }
        }
        if(count==0) {
            System.out.println("No word pairs found!");
        }else {
         System.out.println(count + " word pairs found!");
        }
        if(mirrorWords.size()==0) {
            System.out.println("No mirror words!");
        }else {
            System.out.println("The mirror words are: ");
            System.out.println(String.join(", ", mirrorWords));
        }

    }
}
