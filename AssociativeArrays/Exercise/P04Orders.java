package AssociativeArrays.Exercise;

import java.util.*;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Double>> products = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] data = input.split(" ");
            String productName = data[0];
            double price = Double.parseDouble(data[1]);
            double quantity = Double.parseDouble(data[2]);


            if(!products.containsKey(productName)) {
                products.put(productName, new ArrayList<>());
                products.get(productName).add(price);
                products.get(productName).add(quantity);
            }else {
                products.get(productName).set(0,price);
                products.get(productName).set(1, products.get(productName).get(1) + quantity);
            }

            input = scanner.nextLine();
        }
        products.forEach((k,v) -> System.out.printf("%s -> %.2f%n", k, v.get(0) * v.get(1)));

    }
}
