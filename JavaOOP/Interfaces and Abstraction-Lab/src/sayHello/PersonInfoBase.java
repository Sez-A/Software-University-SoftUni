package sayHello;

public abstract class PersonInfoBase implements Person{
    private String name;
    protected PersonInfoBase(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
