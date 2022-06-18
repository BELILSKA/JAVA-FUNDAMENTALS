package AssociativeArrays.Exercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companyInfo = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String company = data[0];
            String id = data[1];

            if (companyInfo.containsKey(company) && !companyInfo.get(company).contains(id)) {
                companyInfo.get(company).add(id);
            }

            if (!companyInfo.containsKey(company)) {
                companyInfo.put(company, new ArrayList<String>());
                companyInfo.get(company).add(id);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companyInfo.entrySet()) {
            System.out.printf("%s%n", entry.getKey());

            for (String id : entry.getValue()) {
                System.out.printf("-- %s%n", id);
            }
        }


    }
}
