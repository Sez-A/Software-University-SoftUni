import java.util.Scanner;

public class ExamPrep {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int targetBadGradesCnt = Integer.parseInt(scan.nextLine());
        String taskName = scan.nextLine();
        int badGradesCnt = 0;
        boolean fail = false;
        int numberOfProblems = 0;
        String lastProblem = "";
        double allGrades = 0;
        while (!taskName.equals("Enough")) {
            int grade = Integer.parseInt(scan.nextLine());
            if (grade <= 4) {
                //allGrades += grade;
                badGradesCnt++;
            }
            if (badGradesCnt == targetBadGradesCnt) {
                fail = true;
                break;
            }
            numberOfProblems++;
            allGrades += grade;
            lastProblem = taskName;
            taskName = scan.nextLine();
        }

        if (fail) {
            System.out.printf("You need a break, %d poor grades.%n", badGradesCnt);
        } else {
            System.out.printf("Average score: %.2f%n", allGrades / numberOfProblems);
            System.out.printf("Number of problems: %d%n", numberOfProblems);
            System.out.printf("Last problem: %s%n", lastProblem);
        }
    }
}
