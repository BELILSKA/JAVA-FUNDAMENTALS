package FundamentalsFinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        List<String> places = new ArrayList<>();

        Pattern pattern = Pattern.compile("([=\\/])(?<name>[A-Z][a-zA-Z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);

        int travelPoints = 0;
        while (matcher.find()) {
            String location = matcher.group("name");
            travelPoints += location.length();
            places.add(location);
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", places));
        System.out.printf("Travel Points: %d", travelPoints);

    }
}
