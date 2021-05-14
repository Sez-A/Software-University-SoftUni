import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String figureType = scan.nextLine();
        double area = 0;
        switch (figureType) {
            case "square":
                double side = Double.parseDouble(scan.nextLine());
                area += side * side;
                break;
            case "rectangle":
                double width = Double.parseDouble(scan.nextLine());
                double height = Double.parseDouble(scan.nextLine());
                area += width * height;
                break;

            case "circle":
                double radius = Double.parseDouble(scan.nextLine());
                area += Math.PI * Math.pow(radius, 2);
                break;

            case "triangle":
                double triangleSide = Double.parseDouble(scan.nextLine());
                double triangleHeight = Double.parseDouble(scan.nextLine());
                area += (triangleSide * triangleHeight) / 2;
                break;
        }

        System.out.printf("%.3f%n", area);
    }
}
