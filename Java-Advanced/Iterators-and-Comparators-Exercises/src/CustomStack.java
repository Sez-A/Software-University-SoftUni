import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomStack implements Iterable<Integer> {
    private ArrayDeque<Integer> stack;

    public CustomStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(Integer... elements) {
        for (Integer element : elements) {
            this.stack.push(element);
        }
    }

    public Integer pop() {

            return this.stack.pop();

    }

    @Override
    public Iterator<Integer> iterator() {
        return stack.iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }
}
