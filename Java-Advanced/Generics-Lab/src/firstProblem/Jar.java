package firstProblem;

import java.util.ArrayDeque;

public class Jar<T> {
ArrayDeque<T> stack = new ArrayDeque<>();

    public void add(T element) {
        stack.push(element);
    }

    public T remove() {
        return stack.pop();
    }
}
