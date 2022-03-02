package problem2;

public class Main {
    public static void main(String[] args)  {

        Circle circle = new Circle(12D);

        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());

        Rectangle rectangle = new Rectangle(5D,10D);

        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
    }
}
