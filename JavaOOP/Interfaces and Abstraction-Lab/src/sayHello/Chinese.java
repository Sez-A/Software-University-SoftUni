package sayHello;

public class Chinese extends PersonInfoBase implements Person{
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
