package midexam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputItems = scan.nextLine().split(", ");

        List<String> items = new ArrayList<>();

        for (String item : inputItems) {
            items.add(item);
        }

        String input = scan.nextLine();
        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");

            switch (tokens[0]) {
                case "Collect": {
                    String item = tokens[1];
                    boolean isExist = false;
                    for (String currentItem : items) {
                        if (currentItem.equals(item)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        break;
                    } else {
                        items.add(item);
                    }
                }
                break;
                case "Drop": {
                    String item = tokens[1];
                    boolean isExist = false;
                    int index = -1;
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).equals(item)) {
                            isExist = true;
                            index = i;
                            break;
                        }
                    }
                    if (isExist) {
                        items.remove(index);
                    }
                }
                break;
                case "Combine Items": {
                    String[] oldAndNewItem = tokens[1].split(":");
                    String oldItem = oldAndNewItem[0];
                    String newItem = oldAndNewItem[1];
                    boolean isExist = false;
                    int index = -1;
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).equals(oldItem)) {
                            isExist = true;
                            index = i;
                            break;
                        }
                    }
                    if (isExist) {
                        items.add(index + 1, newItem);
                    }
                }
                break;
                case "Renew": {
                    String item = tokens[1];
                    boolean isExist = false;
                    int index = -1;
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).equals(item)) {
                            isExist = true;
                            index = i;
                            break;
                        }
                    }
                    if (isExist) {
                        items.add(items.remove(index));
                    }
                }
                break;
            }
            input = scan.nextLine();
        }
        String join = String.join(", ", items);

        System.out.println(join);
    }
}
