package Lists.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> secondNumList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        int smallerList = Math.min(firstNumList.size(), secondNumList.size());

        for (int i = 0; i < smallerList; i++) {
            int currentNumFirstList = firstNumList.get(i);
            int currentNumSecList = secondNumList.get(secondNumList.size() - 1 - i);

            resultList.add(currentNumFirstList);
            resultList.add(currentNumSecList);
        }
        List<Integer> remainingElements = new ArrayList<>();

        if (firstNumList.size() > secondNumList.size()) {
            remainingElements.add(firstNumList.get(firstNumList.size()-1));
            remainingElements.add(firstNumList.get(firstNumList.size()-2));
        }else {
            remainingElements.add(secondNumList.get(0));
            remainingElements.add(secondNumList.get(1));
        }

        int minNumber = Math.min(remainingElements.get(0), remainingElements.get(1));
        int maxNumber = Math.max(remainingElements.get(0),remainingElements.get(1));
        List<Integer> finalNumbersList = new ArrayList<>();

        for (int number:resultList) {
            if (number > minNumber && number < maxNumber) {
                finalNumbersList.add(number);
            }
        }
        List<Integer> sortedList = finalNumbersList.stream().sorted().collect(Collectors.toList());
        for (int number : sortedList) {
            System.out.print(number + " ");
        }

    }
}
