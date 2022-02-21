package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;
    private int index;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        this.index = -1;
    }

    public void push(String element) {
        this.data.add(element);
        index++;
    }

    public String pop() {
        return this.data.remove(data.size() - 1);
    }

    public String peek() {
        return this.data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

}
