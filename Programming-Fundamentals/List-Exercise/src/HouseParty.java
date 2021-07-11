import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int commandCount = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();
        String input = scan.nextLine();
        int cnt = 1;
        for (int i = 0; i < commandCount; i++) {
            String[] tokens = input.split("\\s+", 2);
            String name = tokens[0];
            if (tokens[1].equals("is going!")) {
                if (guests.contains(name)) {
                    System.out.println(String.format("%s is already in the list!",name));
                }else{
                    guests.add(tokens[0]);
                }

            } else if (tokens[1].equals("is not going!")) {

                if(guests.contains(name)){
                    guests.remove(name);
                }else{
                    System.out.println(String.format("%s is not in the list!",name));
                }

            }
            if(cnt == commandCount){
                break;
            }
            cnt ++;
            input = scan.nextLine();
        }
        printList(guests);
    }
    public static void printList(List<String> guests){
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
