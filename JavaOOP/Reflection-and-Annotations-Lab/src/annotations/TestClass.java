package annotations;

@Subject(categories = {"Test", "Annotations"})
public class TestClass {

    @Author(name = "TestClase")
    public void helloFromTest() {
        Tracker.printMethodsByAuthor(TestClass.class);
    }
}
