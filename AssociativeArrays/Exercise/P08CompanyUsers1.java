package AssociativeArrays.Exercise;

import java.util.*;

public class P08CompanyUsers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companyData = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String companyName = data[0];
            String id = data[1];

            companyData.putIfAbsent(companyName, new ArrayList<>());

            if (companyData.containsKey(companyName)) {
                if (!companyData.get(companyName).contains(id)) {
                    companyData.get(companyName).add(id);
                }
            }



            input = scanner.nextLine();
        }
        for (Map.Entry<String,List<String>> entry : companyData.entrySet()) {
            System.out.println(entry.getKey());

            for (String id : entry.getValue()) {
                System.out.printf("-- %s%n", id);
            }
        }
    }
}
