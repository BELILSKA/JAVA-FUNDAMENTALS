package FundamentalsFinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("@[#]+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()){
            String product = matcher.group("product");
                StringBuilder productGroup = new StringBuilder();
                for (char symbol:product.toCharArray()) {
                    if (Character.isDigit(symbol)){
                        productGroup.append(symbol);
                    }
            }
                if (productGroup.length() == 0) {
                    productGroup.append("00");
                }

            System.out.printf("Product group: %s%n", productGroup);

            }else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
