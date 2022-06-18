package FundamentalsFinalExamPreparation;

import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<String> products = new ArrayList<>();
        int totalCalories = 0;

        Pattern pattern = Pattern.compile("([|#])(?<name>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String product = matcher.group("name");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;

            products.add(String.format("Item: %s, Best before: %s, Nutrition: %d", product, date,calories));
        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        products.forEach(System.out :: println);

    }
}
