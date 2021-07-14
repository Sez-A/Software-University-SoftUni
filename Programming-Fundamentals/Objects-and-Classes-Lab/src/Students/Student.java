package Students;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public Student(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public String getHometown() {
        return this.hometown;
    }

    public void setFirstName(String firstName) {

    }

    public void setLastName(String lastName) {

    }

    public void setAge(int age) {

    }

    public void setHometown(String hometown) {

    }

    public String getString() {
        return String.format("%s %s is %d years old", this.getFirstName(),
                this.getLastName(),
                this.getAge());
    }
}
