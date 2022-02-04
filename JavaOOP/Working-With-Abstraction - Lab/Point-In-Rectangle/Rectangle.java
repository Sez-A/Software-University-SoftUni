package problem2;
public class Rectangle {
    private Point2D bottomLeft;
    private Point2D topRight;

    public Rectangle(Point2D bottomLeft, Point2D topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point2D point) {
        return point.getX() >= bottomLeft.getX() &&
                point.getY() >= bottomLeft.getY() &&
                point.getX() <= topRight.getX() &&
                point.getY() <= topRight.getY();
    }

    // Solution in Main         int[] coordinates = Arrays.stream(scan.nextLine().split(" "))
    //                .mapToInt(Integer::parseInt)
    //                .toArray();
    //
    //        Point2D bottomLeft = new Point2D(coordinates[0], coordinates[1]);
    //        Point2D topRight = new Point2D(coordinates[2], coordinates[3]);
    //        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
    //
    //        int n = Integer.parseInt(scan.nextLine());
    //
    //        while (n-- > 0) {
    //            coordinates = Arrays.stream(scan.nextLine().split(" "))
    //                    .mapToInt(Integer::parseInt)
    //                    .toArray();
    //            Point2D currentPoint = new Point2D(coordinates[0], coordinates[1]);
    //            System.out.println(rectangle.contains(currentPoint));
    //        }
}
