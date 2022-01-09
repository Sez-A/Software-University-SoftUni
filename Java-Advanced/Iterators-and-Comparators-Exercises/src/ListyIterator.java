import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterator<String> {
    private List<String> collection;
    private int index;
    private int hasNextIndex;

    public ListyIterator(String... varargs) {
        this.collection = new ArrayList<>();
        this.index = 0;
        this.hasNextIndex = 0;

        for (String element : varargs) {
            this.collection.add(element);
        }
    }

    public boolean move() {
        if (this.hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println(this.collection.get(index));
    }

    public boolean hasNext() {
        if (this.index < this.collection.size() - 1) {
            return true;
        }
        return false;

    }

    @Override
    public String next() {
        if (this.index < this.collection.size() - 2) {
            return this.collection.get(index + 1);
        }
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super String> action) {
        Iterator.super.forEachRemaining(action);
    }

    public boolean isEmpty() {
        return this.collection.isEmpty();
    }

    public String printAll() {
        StringBuilder sb = new StringBuilder();
        for (String s : collection) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
}
