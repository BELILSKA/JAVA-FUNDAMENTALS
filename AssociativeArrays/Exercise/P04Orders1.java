package AssociativeArrays.Exercise;

import java.util.*;

public class P04Orders1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Double>> productMap = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] inputData = input.split("\\s+");
            String productName = inputData[0];
            double price = Double.parseDouble(inputData[1]);
            double quantity = Double.parseDouble(inputData[2]);

            if (!productMap.containsKey(productName)) {
                productMap.put(productName,new ArrayList<>());
                productMap.get(productName).add(price);
                productMap.get(productName).add(quantity);
            }else {
                double currentQuantity = productMap.get(productName).get(1);
                productMap.get(productName).set(1,currentQuantity + quantity);
                productMap.get(productName).set(0,price);
            }

            input = scanner.nextLine();
        }
       productMap.forEach((k,v)-> System.out.printf("%s -> %.2f%n",k, v.get(0) * v.get(1)));
    }
}
