import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double income = Double.parseDouble(scan.nextLine());
        double averageGrade = Double.parseDouble(scan.nextLine());
        double minimalSalary = Double.parseDouble(scan.nextLine());

        double scholarship = averageGrade * 25;

        double socScholarship = 0.35 * minimalSalary;

        if (income > minimalSalary && averageGrade < 5.5) {
            System.out.println("You cannot get a scholarship!");
        } else if (income < minimalSalary && averageGrade < 4.50) {
            System.out.println("You cannot get a scholarship!");
        } else if (income < minimalSalary && averageGrade >= 4.5 && averageGrade < 5.5) {
            System.out.printf("You get a Social scholarship %.0f BGN", socScholarship);
        } else if (income < minimalSalary && averageGrade >= 4.5 && socScholarship > scholarship) {
            System.out.printf("You get a Social scholarship %.0f BGN", socScholarship);
        } else if (income < minimalSalary && averageGrade >= 5.5 && scholarship > socScholarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", scholarship);
        } else if (income >= minimalSalary && averageGrade >= 5.5) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(scholarship));
        }
    }
}
