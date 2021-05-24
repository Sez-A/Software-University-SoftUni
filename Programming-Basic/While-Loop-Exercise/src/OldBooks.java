import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String targetBook = scan.nextLine();
        String currentBook = scan.nextLine();
        int checkedBookCnt = 0;
        boolean isFind = false;
        while (!currentBook.equals("No More Books")) {
            if (currentBook.equals(targetBook)) {
                isFind = true;
                break;
            }
            checkedBookCnt++;
            currentBook = scan.nextLine();
        }
        if (isFind) {
            System.out.printf("You checked %d books and found it.", checkedBookCnt);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", checkedBookCnt);
        }
    }
}
