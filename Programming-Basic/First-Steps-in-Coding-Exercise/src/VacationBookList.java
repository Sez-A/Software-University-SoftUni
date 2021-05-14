import java.util.Scanner;

public class VacationBookList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pages = Integer.parseInt(scan.nextLine());
        int pagesForHour = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());

        int timeForReadABook = pages / pagesForHour;
        int neededTime = timeForReadABook / days;

        System.out.println(neededTime);
    }
}
