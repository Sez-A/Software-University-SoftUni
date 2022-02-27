package sayHello;

public class Bulgarian extends PersonInfoBase implements Person{
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
