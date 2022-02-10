package problem1;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (!correctSide(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

        this.length = length;

    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (!correctSide(width)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (!correctSide(height)) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private boolean correctSide(double side) {
        if (side > 0) {
            return true;
        }
        return false;

    }

    public double calculateSurfaceArea() {
        return 2 * this.getLength() * this.getWidth()
                + 2 * this.getLength() * this.getHeight()
                + 2 * this.getWidth() * this.getHeight();
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.getLength() * this.getHeight()
                + 2 * this.getWidth() * this.getHeight();
    }

    public double calculateVolume() {
        return this.getLength() * this.getWidth() * this.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                        "Lateral Surface Area - %.2f%n" +
                        "Volume – %.2f%n", this.calculateSurfaceArea(),
                this.calculateLateralSurfaceArea(), this.calculateVolume());
    }
}
