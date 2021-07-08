import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> left = readList(scan);
        List<Integer> right = readList(scan);

        List<Integer> result = new ArrayList<>();

        int i = 0;
        while (i < left.size() && i < right.size()) {

            result.add(left.get(i));
            result.add(right.get(i));
            i++;
        }

        if (left.size() > i) {
            result.addAll(getLeftovers(left, i));
           // addLeftovers(result, left, i);
        } else if (right.size() > i) {
           // addLeftovers(result, right, i);
            result.addAll(getLeftovers(right,i));
        }

        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }

    private static List<Integer> getLeftovers(List<Integer> left, int i) {

        List<Integer> result = new ArrayList<>();
        for (int j = i; j < left.size(); j++) {
            result.add(left.get(j));
        }
        return result;
    }

//    private static void addLeftovers(List<Integer> result, List<Integer> left, int i) {
//        for (int j = i; j < left.size() ; j++) {
//            result.add(left.get(j));
//        }
//    }

    private static List<Integer> readList(Scanner scan) {
        String[] split = scan.nextLine().split(" ");
        List<Integer> result = Arrays.stream(split).
                map(Integer::parseInt)
                .collect(Collectors.toList());
        return result;
    }
}
