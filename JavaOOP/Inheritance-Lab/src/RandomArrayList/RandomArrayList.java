package RandomArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {
    private List<Object> data;
    private int index;
    public RandomArrayList() {
        this.data = new ArrayList<>();
        this.index = 0;
    }

    public Object getRandomElement() {
        Random random = new Random();
        int number = random.nextInt();
        data.add(number);
        return data.remove(index);
    }
}
