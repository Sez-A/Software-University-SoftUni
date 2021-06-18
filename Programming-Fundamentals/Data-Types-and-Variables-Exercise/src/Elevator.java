import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         int peopleCnt = Integer.parseInt(scan.nextLine());
         int capacity = Integer.parseInt(scan.nextLine());
         double courses =  Math.ceil(peopleCnt * 1.0 / capacity);
        System.out.println(String.format("%.0f",courses));

    }
}
