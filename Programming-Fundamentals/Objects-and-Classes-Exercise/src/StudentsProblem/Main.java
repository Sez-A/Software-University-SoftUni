package StudentsProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Students> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Students student = new Students(firstName, lastName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparingDouble(Students::getGrade).reversed());
        for (Students student : students) {
            System.out.println(student);
        }
    }
}
