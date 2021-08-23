package midexam04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] inputProducts = input.split("!");


        List<String> products = new ArrayList<>();
        for (String inputProduct : inputProducts) {
            products.add(inputProduct);
        }

        while (!(input = scan.nextLine()).equals("Go Shopping!")) {
            String[] tokens = input.split("\\s+");
            String item = tokens[1];
            boolean isExist = false;

            switch (tokens[0]) {
                case "Urgent":
                    isExist = existingCheck(products, item, isExist);
                    if (!isExist) {
                        products.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    int index = -1;
                    isExist = existingCheck(products, item, isExist);
                    if (isExist) {
                        index = findIndex(products, item, index);
                        products.remove(index);
                    }
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    int oldItemIndex = -1;
                    isExist = existingCheck(products, item, isExist);
                    if (isExist) {
                        oldItemIndex = findIndex(products, item, oldItemIndex);
                        products.set(oldItemIndex, newItem);
                    }
                    break;
                case "Rearrange":
                    int ind = -1;
                    isExist = existingCheck(products, item, isExist);
                    if (isExist) {
                        ind = findIndex(products, item, ind);
                        products.add(products.remove(ind));
                    }
                    break;
            }
        }

        System.out.println(String.join(", ", products));
    }


    private static boolean existingCheck(List<String> products, String item, boolean isExist) {
        for (String product : products) {
            if (product.equals(item)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    private static int findIndex(List<String> products, String item, int index) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
