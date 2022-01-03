import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void swap(int firstInd, int secondInd) {
        T temp = values.get(firstInd);
        T secondElement = values.get(secondInd);
        values.remove(firstInd);
        values.add(firstInd, secondElement);
        values.remove(secondInd);
        values.add(secondInd, temp);
    }


    public int greaterElementsCnt(T element) {
        return (int) values.stream().filter(i -> i.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return sb.toString().trim();
    }
}
