package ArticlesProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];
        Articles article = new Articles(title, content, author);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            input = scan.nextLine().split(": ");
            switch (input[0]) {
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }
        System.out.println(article);
    }
}
