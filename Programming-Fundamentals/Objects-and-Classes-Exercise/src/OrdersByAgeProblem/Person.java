package OrdersByAgeProblem;

public class Person {
    String name;
    String id;
    int age;

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        String result = String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        return result;
    }
}
