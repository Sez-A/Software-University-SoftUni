import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }
}
