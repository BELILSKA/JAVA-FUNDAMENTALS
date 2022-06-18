package FundamentalsFinalExamPreparation;

import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pianoPieces = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] piecesInfo = scanner.nextLine().split("\\|");
            String pieceName = piecesInfo[0];
            String composer = piecesInfo[1];
            String key = piecesInfo[2];

            pianoPieces.put(pieceName, new ArrayList<>());
            pianoPieces.get(pieceName).add(composer);
            pianoPieces.get(pieceName).add(key);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commandsLine = input.split("\\|");
            String command = commandsLine[0];
            String piece = commandsLine[1];

            switch (command) {
                case "Add":
                    String composerToAdd = commandsLine[2];
                    String keyToAdd = commandsLine[3];

                    if (!pianoPieces.containsKey(piece)) {
                        pianoPieces.put(piece, new ArrayList<>());
                        pianoPieces.get(piece).add(composerToAdd);
                        pianoPieces.get(piece).add(keyToAdd);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composerToAdd, keyToAdd);
                    } else {
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    if (pianoPieces.containsKey(piece)) {
                        pianoPieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commandsLine[2];

                    if (pianoPieces.containsKey(piece)) {
                        pianoPieces.get(piece).remove(1);
                        pianoPieces.get(piece).add(1,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piece,newKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        pianoPieces.forEach((k,v)-> System.out.printf("%s -> Composer: %s, Key: %s%n", k,v.get(0),v.get(1)));
    }


}

