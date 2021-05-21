import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String studentName = scan.nextLine();

        int failCnt = 0;

        int currentClass = 1;
        double averageGrade = 0;
        for (int i = 0; i < 12; i++) {


            double grade = Double.parseDouble(scan.nextLine());
            if (grade >= 4) {
                averageGrade += grade;
                currentClass++;
            } else {
                failCnt++;
            }
            if (failCnt > 1) {
                System.out.printf("%s has been excluded at %d grade%n", studentName, currentClass);
                return;
            }
        }

        averageGrade /= 12;
        System.out.printf("%s graduated. Average grade: %.2f%n", studentName, averageGrade);
    }
}
