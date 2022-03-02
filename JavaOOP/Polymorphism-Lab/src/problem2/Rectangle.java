package problem2;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (this.height + this.width);
    }

    @Override
    public Double calculateArea() {
        return this.width * this.height;
    }
}
