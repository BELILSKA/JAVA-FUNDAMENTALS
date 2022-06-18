package Lists.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] commandLine = input.split(":");
            String command = commandLine[0];
            String lessonTitle = commandLine[1];

            switch (command) {
                case "Add":
                    if (!lessons.contains(lessonTitle)) {
                        lessons.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLine[2]);
                    if (!lessons.contains(lessonTitle)) {
                        lessons.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    lessons.remove(lessonTitle);
                    lessons.remove(lessonTitle + "-Exercise");
                    break;
                case "Swap":
                    String lessonToSwap = commandLine[2];
                    if (lessons.contains(lessonTitle) && lessons.contains(lessonToSwap)) {
                        int firstIndex = lessons.indexOf(lessonTitle);
                        int secondIndex = lessons.indexOf(lessonToSwap);
                        Collections.swap(lessons,firstIndex,secondIndex);

                        if (lessons.contains(lessonTitle + "-Exercise")) {
                            int indexExercise = lessons.indexOf(lessonTitle + "-Exercise");
                            String lesson = lessons.get(indexExercise);
                            lessons.add(secondIndex + 1,lesson);
                            lessons.remove(indexExercise + 1);
                        }else if (lessons.contains(lessonToSwap + "-Exercise")) {
                            int indexExercise = lessons.indexOf(lessonToSwap + "-Exercise");
                            String lesson = lessons.get(indexExercise);
                            lessons.add(firstIndex + 1,lesson);
                            lessons.remove(indexExercise + 1);
                        }
                    }
                    break;
                case "Exercise":
                    if (!lessons.contains(lessonTitle) && !lessons.contains(lessonTitle + "-Exercise")) {
                        lessons.add(lessonTitle);
                        lessons.add(lessonTitle + "-Exercise");
                    }else if (lessons.contains(lessonTitle) && !lessons.contains(lessonTitle + "-Exercise")) {
                        lessons.add(lessons.indexOf(lessonTitle)+1, lessonTitle + "-Exercise");
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < lessons.size(); i++) {
            String lesson = lessons.get(i);
            System.out.println(i + 1 + "." + lesson);
        }
    }
}
