import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String presentationName = scan.nextLine();
        double finalGrade = 0.;
        int presCnt = 0;
        while (!presentationName.equals("Finish")) {
            double averageGrade = 0.0;
            presCnt++;
            for (int i = 0; i < n; i++) {
                double grade = Double.parseDouble(scan.nextLine());
                averageGrade += grade;
            }
            finalGrade += averageGrade / n;
            System.out.printf("%s - %.2f.%n", presentationName, (averageGrade / n));
            presentationName = scan.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.%n", finalGrade / presCnt);
    }
}
