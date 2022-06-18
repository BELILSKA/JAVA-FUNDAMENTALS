package Lists.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            switch (command) {
                case "merge":
                    List<String> result = new ArrayList<>();
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (startIndex > 0 && endIndex < data.size()) {
                        result.addAll(data.subList(0, startIndex));
                    }

                    if (startIndex < data.size()) {
                        List<String> mergedElements = new ArrayList<>();
                        mergedElements = data.subList(startIndex, endIndex + 1);
                        StringBuilder merged = new StringBuilder();

                        for (String element : mergedElements) {
                            merged.append(element);
                        }
                        result.add(merged.toString());
                    }

//                    if (startIndex < data.size() && endIndex >= data.size()) {
//                        mergedElements = data.subList(startIndex, data.size());
//
//                        for (String element : mergedElements) {
//                            merged.append(element);
//                        }
//                        result.add(merged.toString());
//                    }

                    if (endIndex + 1 < data.size()) {
                        result.addAll(data.subList(endIndex + 1, data.size()));
                    }

                    if (!result.isEmpty()) {
                        data = result;
                    }

                    break;
                case "divide":
                    int index = Integer.parseInt(commandLine[1]);
                    int partitions = Integer.parseInt(commandLine[2]);

                    result = new ArrayList<>();
                    String element = data.get(index);
                    if (element.length() % partitions == 0) {
                        int symbols = element.length() / partitions;
                        for (int i = 0; i < partitions; i++) {
                            result.add(element.substring(0, symbols));
                            element = element.substring(symbols);
                        }
                        data.remove(index);
                        data.addAll(index, result);

                    } else {
                        int symbols = element.length() / partitions;
                        for (int i = 0; i < partitions; i++) {
                            if (i == partitions - 1) {
                                result.add(element);
                            } else {
                                result.add(element.substring(0, symbols));
                                element = element.substring(symbols);
                            }
                        }
                        data.remove(index);
                        data.addAll(index, result);

                        break;
                    }
            }
            input = scanner.nextLine();
        }
            System.out.print(String.join(" ", data));
    }
}
