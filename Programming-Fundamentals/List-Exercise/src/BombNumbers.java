//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
// МОЯ КОД - 60/100 В Judge
//public class BombNumbers {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        List<Integer> numbers = readIntList(scan);
//
//
//        String input = scan.nextLine();
//        String[] tokens = input.split(" ");
//        Integer[] intTokens = new Integer[tokens.length];
//
//        for (int i = 0; i < intTokens.length; i++) {
//            intTokens[i] = Integer.parseInt(tokens[i]);
//        }
//
//        int bombNumber = intTokens[0];
//        int powerOfBombNumber = intTokens[1];
//
//        for (int i = 0; i < numbers.size(); i++) {
//            int cnt1 = 0;
//            if (numbers.get(i) == bombNumber) {
//                for (int j = numbers.indexOf(i); j <= numbers.size(); j++) {
//                    if(i + 1 >= numbers.size()){
//                        break;
//                    }
//                    numbers.remove(i + 1);
//                    cnt1++;
//                    if (cnt1 == powerOfBombNumber) {
//                        break;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < numbers.size(); i++) {
//            int cnt2 = 0;
//            if (numbers.get(i) == bombNumber) {
//                for (int j = numbers.size() - 1; j > 0; j--) { // може да е и от numbers.size
//                    if(i - 1 < 0){
//                        break;
//                    }
//                    numbers.remove(i - 1);
//                    i--;
//                    cnt2++;
//                    if (cnt2 == powerOfBombNumber) {
//                        break;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i) == bombNumber) {
//                numbers.remove(numbers.get(i));
//                if(numbers.contains(bombNumber)){
//                    continue;
//                }
//                break;
//            }
//        }
//
//        int sum = 0;
//        for (Integer number : numbers) {
//            sum += number;
//        }
//        System.out.println(sum);
//    }
//
//
//    public static List<Integer> readIntList(Scanner scanner) {
//        String[] numbersAsString = scanner.nextLine().split("\\s+");
//        List<Integer> numbers = new ArrayList<>();
//        for (String number : numbersAsString) {
//            numbers.add(Integer.parseInt(number));
//        }
//        return numbers;
//    }
//}

/* Код който написах на 21.06.21 100/100 в judge има напредък има :Д 
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        int[] bombNumInfo = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombNum = bombNumInfo[0];
        int power = bombNumInfo[1];
        int bombNumInd = -1;
        int sum = 0;
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) == bombNum) {
                bombNumInd = i;
                sequence.set(bombNumInd, 0);
                int leftSide = bombNumInd - 1;
                for (int k = 0; k < power; k++) {
                    if (leftSide < 0) {

                    } else {
                        sequence.set(leftSide--, 0);
                    }
                }
                int rightSide = bombNumInd + 1;
                for (int j = 0; j < power; j++) {
                    if (rightSide >= sequence.size()) {

                    } else {
                        sequence.set(rightSide++, 0);
                    }
                }
            }

        }

        for (Integer number : sequence) {
            sum += number;
        }
        System.out.println(sum);
    }
}
*/


                             //КОД ВЗЕТ ОТ ИНТЕРНЕТ 100/100 В Judge


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        @SuppressWarnings("resource")

        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = sc.nextLine().split("\\s+");
        int bombNumber = Integer.parseInt(input[0]);
        int bombPower = Integer.parseInt(input[1]);

        int sum = 0;

        while (numbers.contains(bombNumber)) {
            int indexBomb = numbers.indexOf(bombNumber);

            int left = Math.max(0, indexBomb - bombPower);
            int right = Math.min(numbers.size() - 1, indexBomb + bombPower);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);

    }
}

