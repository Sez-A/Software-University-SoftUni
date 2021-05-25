import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int floors = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());
        int firstTime = 0;
        for (int i = floors; i >= 1; i--) {
            for (int j = 0; j < rooms; j++) {
                if (firstTime == 0) {
                    System.out.print("L" + i + j + " ");
                } else {
                    if (i % 2 != 0) {
                        System.out.printf("A%d%d ", i, j);
                    } else {
                        System.out.printf("O%d%d ", i, j);
                    }
                }
            }
            System.out.println();
            firstTime++;
        }
    }
}
