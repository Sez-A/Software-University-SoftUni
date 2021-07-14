package SecondProblemStudents;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Students> students = new ArrayList<>();
        while (!"end".equals(input)) {
            String[] studentParts = input.split(" ");

            Students found = findByFistAndLastName(students,studentParts[0],studentParts[1]);
            if(found != null){
                students.remove(found);
            }

            String firstName = studentParts[0];
            String lastName = studentParts[1];
            int age = Integer.parseInt(studentParts[2]);
            String hometown = studentParts[3];

           Students student = new Students(firstName,lastName,age,hometown);

            students.add(student);

            input = scan.nextLine();
        }
        String city = scan.nextLine();

        for (Students current : students) {
            if (current.getHometown().equals(city)) {
                System.out.println(current.getString());
            }
        }
    }

    private static Students findByFistAndLastName(List<Students> students ,String firstName,String lastName){
        for (Students student : students) {
            if(student.getFirstName().equals(firstName)
                    && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }
}

