package problem2;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }


    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day."
                , this.getName(), this.getAge(), this.productPerDay());
    }

    private double calculateProductPerDay() {
        if (age < 6) {
            return 2;
        } else if (age < 12) {
            return 1;
        } else {
            return 0.75;
        }

    }
}
