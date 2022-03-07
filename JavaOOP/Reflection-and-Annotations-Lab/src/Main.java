import annotations.Author;
import annotations.TestClass;
import annotations.Tracker;

public class Main {
    @Author(name = "Gosho")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
        Tracker.printMethodsByAuthor(Main.class);

        TestClass testClass = new TestClass();
        testClass.helloFromTest();
    }

    @Author(name = "Ivan")
    public static void hello() {

    }
}
