package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Student> students = new ArrayList<>();
        while (!"end".equals(input)) {
            String[] studentParts = input.split(" ");

            String firstName = studentParts[0];
            String lastName = studentParts[1];
            int age = Integer.parseInt(studentParts[2]);
            String hometown = studentParts[3];

            Student student = new Student(firstName, lastName, age, hometown);

            students.add(student);

            input = scan.nextLine();
        }
        String city = scan.nextLine();

        for (int i = 0; i < students.size(); i++) {
            Student current = students.get(i);
            if(current.getHometown().equals(city)){
                System.out.println(current.getString());
            }
        }
    }

//    private static void printStudent(Student current) {
//        System.out.printf("%s %s is %d years old%n",current.getFirstName(),
//                current.getLastName(),
//                current.getAge());
//    }
}
