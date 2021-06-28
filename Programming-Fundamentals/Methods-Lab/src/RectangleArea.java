import java.util.Scanner;

public class RectangleArea {

    public static int rectangleArea (int width,int length){
        return width * length;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int area = rectangleArea (width , length);
        System.out.println(area);
    }
}
