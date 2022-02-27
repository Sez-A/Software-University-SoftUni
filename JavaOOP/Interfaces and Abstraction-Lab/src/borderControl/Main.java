package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        List<Identifiable> identifiables = new ArrayList<>();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            Identifiable identifiable;
            if(tokens.length == 3) {
            identifiable = new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
            }else {
                identifiable = new Robot(tokens[0],tokens[1]);
            }
            identifiables.add(identifiable);
            line = scan.nextLine();
        }
        String targetIdEndNumbers = scan.nextLine();

        for (Identifiable identifiable : identifiables) {
            if(identifiable.getId().endsWith(targetIdEndNumbers)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
