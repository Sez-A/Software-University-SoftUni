import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        printMatrix(n);
    }
    public static void printMatrix(int number){
        for (int row = 1; row <=number ; row++) {
            for (int col = 1; col <= number; col++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
