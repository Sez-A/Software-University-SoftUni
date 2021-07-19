import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // My code not work.
//        String[] input = scan.nextLine().split("\\s+");
//        List<Integer> numbers = new ArrayList<>();
//
//        for (String number : input) {
//            numbers.add(Integer.parseInt(number));
//        }
//
//        numbers
//                .stream()
//                .sorted((n1,n2) -> n2 - n1)
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < numbers.size() ; i++) {
//            if(i < 3){
//                System.out.println(numbers.get(i));
//            }else{
//                break;
//            }
//        }

//                              SoftUni code work!
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {

            if (i < 3) {
                System.out.println(numbers.get(i));
            } else {
                break;
            }

        }
    }
}
