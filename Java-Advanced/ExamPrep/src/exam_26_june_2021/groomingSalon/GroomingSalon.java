package exam_26_june_2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;

    }

    public List<Pet> getData() {
        return data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("The grooming salon has the following clients:")
                .append(System.lineSeparator());

        for (Pet pet : data) {
            sb.append(pet.getName() + " " + pet.getOwner())
                    .append(System.lineSeparator());

        }
        return sb.toString().trim();
    }

}
