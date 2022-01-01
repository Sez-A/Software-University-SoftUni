package secondProblem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    //  @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T item) {
        T[] ts = (T[]) Array.newInstance(item.getClass(), length);
        Arrays.fill(ts, item);
        return ts;
    }

    // @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] arr = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(arr, item);
        return arr;
    }
}
