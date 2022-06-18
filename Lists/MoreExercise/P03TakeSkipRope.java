package Lists.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();

        for (char symbol : text.toString().toCharArray()) {
            if (Character.isDigit(symbol)) {
                numbers.add(Integer.parseInt(String.valueOf(symbol)));
            }else {
                nonNumbers.add(symbol);
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            }else {
                skipList.add(numbers.get(i));
            }
        }

        StringBuilder resultString = new StringBuilder();
        int indexSkip = 0;

        for (int i = 0; i < takeList.size(); i++) {
            int take = takeList.get(i);
            int skip = skipList.get(i);

            if (indexSkip + take > text.length()){
                take = text.length() - indexSkip;
            }
            for (int j = 0; j < take; j++){
                if (indexSkip + j < nonNumbers.size()){
                resultString.append(nonNumbers.get(indexSkip + j));
                }
            }
            indexSkip += take + skip;
        }

        System.out.println(resultString);

    }
}

