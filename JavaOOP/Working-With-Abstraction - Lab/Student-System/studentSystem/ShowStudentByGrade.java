package studentSystem;

public class ShowStudentByGrade {

    public static void showStudent(Student student) {
        String out = student.toString();

        if (student.getGrade() >= 5.00) {
            out += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            out += " Average student.";
        } else {
            out += " Very nice person.";
        }

        System.out.println(out);
    }
}
