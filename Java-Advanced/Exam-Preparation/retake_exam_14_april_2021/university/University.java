package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        if (studentExist(student)) {
            return "Student is already in the university";
        } else if (this.students.size() < capacity) {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        boolean b = this.students.remove(student);
        if (b) {
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";

        }

    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private boolean studentExist(Student target) {
        for (Student current : students) {
            if (target.getFirstName().equals(current.firstName) &&
                    target.getLastName().equals(current.getLastName())
                    && target.getBestSubject().equals(current.getBestSubject())) {

                return true;
            }
        }
        return false;
    }
}
