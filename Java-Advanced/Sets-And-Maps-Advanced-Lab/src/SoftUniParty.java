import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        while (!input.equals("PARTY")) {
            char firstSymbol = input.charAt(0);
            if(Character.isDigit(firstSymbol)) {
                vip.add(input);
            }else{
                regular.add(input);
            }
            input = scan.nextLine();
        }

        while (!(input = scan.nextLine()).equals("END")) {
            if (vip.contains(input)) {
                vip.remove(input);
            } else if (regular.contains(input)) {
                regular.remove(input);
            }
        }
        System.out.println(vip.size() + regular.size());
        for (String v : vip) {
            System.out.println(v);
        }

        for (String r : regular) {
            System.out.println(r);
        }
    }
}
