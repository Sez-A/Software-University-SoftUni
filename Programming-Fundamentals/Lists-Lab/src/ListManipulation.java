import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine()
                .split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while(true){
            String line = scan.nextLine();
            if(line.equals("end")){
                break;
            }
            String [] command = line.split(" ");
             switch (command[0]){
                 case "Add":
                     int numberToAdd = Integer.parseInt(command[1]);
                     numbers.add(numberToAdd);
                     break;
                 case "Remove":
                     int numberToRemove = Integer.parseInt(command[1]);
                     numbers.remove(Integer.valueOf(numberToRemove));
                     break;
                 case "RemoveAt":
                     int indexToRemove = Integer.parseInt(command[1]);
                     numbers.remove(indexToRemove);
                     break;
                 case "Insert":
                     int numberToInsert = Integer.parseInt(command[1]);
                     int indexToInsert = Integer.parseInt(command[2]);
                     numbers.add(indexToInsert,numberToInsert);
                     break;
             }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
