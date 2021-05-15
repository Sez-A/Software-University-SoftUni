import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double income = Double.parseDouble(scan.nextLine());
        double averageGrade = Double.parseDouble(scan.nextLine());
        double minimalSalary = Double.parseDouble(scan.nextLine());

        double scholarship = 0;
        if (income > minimalSalary && averageGrade < 5.5) {
            System.out.println("You cannot get a scholarship!");
        } else if (income >= minimalSalary && averageGrade >= 5.50) {
            scholarship += averageGrade * 25;
            System.out.println(String.format("You get a scholarship for excellent results %.0f BGN"
                    , Math.floor(scholarship)));
        } else if (income < minimalSalary && averageGrade >= 5.50) {
            double socialScholarship = minimalSalary * 0.35;
            scholarship = averageGrade * 25;
            if (socialScholarship >= scholarship) {
                System.out.printf("You get a Social scholarship %.0f BGN%n", socialScholarship);
            } else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN%n", scholarship);
            }
        }else if (income < minimalSalary && averageGrade >= 4.50) {
            double socialScholarship = minimalSalary * 0.35;
            System.out.printf("You get a Social scholarship %.0f BGN%n", socialScholarship);
        }else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}

