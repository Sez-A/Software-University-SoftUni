package demoOOP;

public class Dog extends Animal {
    public Dog(String type, int age) {
        super(type, age);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void eat() {
        System.out.println("Eat like dog");
    }
}
