package Lists.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> dataLine = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "merge":
                    List<String> result = new ArrayList<>();
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (startIndex > 0 && startIndex < dataLine.size()) {
                        result = dataLine.subList(0, startIndex);
                    }
                    if (startIndex < dataLine.size()) {
                    List<String> mergeElements = dataLine.subList(startIndex, endIndex + 1);
                    String merged = "";
                        for (String mergeElement : mergeElements) {
                            merged += mergeElement;
                        }
                        result.add(merged);
                    }


                    if (endIndex + 1 <= dataLine.size() - 1) {
                    result.addAll(dataLine.subList(endIndex + 1, dataLine.size()-1));
                    }
                    if (!result.isEmpty()) {
                    dataLine = result;
                    }
                    break;

                case "divide":
                    result = new ArrayList<>();
                    int index = Integer.parseInt(commandLine[1]);
                    int partition = Integer.parseInt(commandLine[2]);
                    String element = dataLine.get(index);
                    if (element.length() % partition == 0) {
                        int symbols = element.length() / partition;
                        for (int i = 0; i < partition; i++) {
                            result.add(element.substring(0,symbols));
                            element = element.substring(symbols);
                        }
                        dataLine.remove(index);
                        dataLine.addAll(index,result);

                    }else {
                        int symbols = element.length() / partition;
                        for (int i = 0; i < partition; i++) {
                            if (i == partition - 1) {
                                result.add(element);
                            }else {
                                result.add(element.substring(0,symbols));
                                element = element.substring(symbols);
                            }
                        }
                        dataLine.remove(index);
                        dataLine.addAll(index,result);

                    }
                    break;
            }


            input = scanner.nextLine();
        }
        dataLine.forEach(s -> System.out.print(s + " "));
    }
}
