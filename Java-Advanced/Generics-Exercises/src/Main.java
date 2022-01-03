import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    int firstInd = Integer.parseInt(tokens[1]);
                    int secondInd = Integer.parseInt(tokens[2]);
                    customList.swap(firstInd, secondInd);
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
                    System.out.print(customList);
                    break;
            }
        }
    }
}
