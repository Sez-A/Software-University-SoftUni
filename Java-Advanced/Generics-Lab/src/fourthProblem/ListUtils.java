package fourthProblem;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        checkSize(list);
        return list.stream().max(T::compareTo).orElse(null);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        checkSize(list);
        return list.stream().min(T::compareTo).orElse(null);
    }

    private static <T extends Comparable<T>> void checkSize(List<T> list) {
        if (list.size() == 0) {
         throw new IllegalArgumentException() ;
        }
    }
}
