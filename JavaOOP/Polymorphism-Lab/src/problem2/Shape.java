package problem2;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public abstract Double calculatePerimeter();

    public abstract Double calculateArea();

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }
}
