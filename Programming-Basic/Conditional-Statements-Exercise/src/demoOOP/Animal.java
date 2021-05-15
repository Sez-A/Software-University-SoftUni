package demoOOP;

public abstract class Animal implements AnimalInf {
    protected String type;
    protected int age;

    protected Animal(String type, int age) {
        this.type = type;
        this.age = age;
    }

    protected String getType() {
        return type;
    }

    protected int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("This: %s - %d year old", this.type, this.age);
    }
}
