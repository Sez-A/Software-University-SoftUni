import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String initialDestinations = scan.nextLine();
        StringBuilder sb = new StringBuilder(initialDestinations);
        String command = "";
        while (!(command = scan.nextLine()).equals("Travel")) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(tokens[1]);
                    String stringForInsert = tokens[2];
                    if (validIndex(insertIndex, sb.toString())) {
                        sb.insert(insertIndex, stringForInsert);
                        initialDestinations = sb.toString();
                    }
                    System.out.println(sb);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (validIndex(startIndex, sb.toString()) && validIndex(endIndex, sb.toString())) {
                        sb.replace(startIndex, endIndex + 1, "");
                        initialDestinations = sb.toString();
                    }
                    System.out.println(sb);
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (initialDestinations.contains(oldString)) {
                        initialDestinations = initialDestinations.replaceAll(oldString, newString);
                        sb = new StringBuilder(initialDestinations);
                    }
                    System.out.println(sb);
                    break;
            }
        }

        System.out.println(String.format("Ready for world tour! Planned stops: %s", initialDestinations));
    }

    private static boolean validIndex(int index, String text) {
        return index >= 0 && index < text.length();
    }
}
