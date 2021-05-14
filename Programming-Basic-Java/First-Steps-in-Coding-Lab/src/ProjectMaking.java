import java.util.Scanner;

public class ProjectMaking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int projectCnt = Integer.parseInt(scan.nextLine());
        System.out.printf("The architect %s will need %d hours to complete %d project/s.%n"
                , name, projectCnt * 3, projectCnt);
    }
}
