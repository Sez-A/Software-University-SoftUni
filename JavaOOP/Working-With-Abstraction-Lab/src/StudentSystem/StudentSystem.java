package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private  Map<String, Student>  studentsRepo;

    public StudentSystem() {
        this.studentsRepo = new HashMap<>();
    }

    public Map<String, Student> getStudentsRepo() {
        return studentsRepo;
    }

    public void parseCommand(String[] args) {
        String name = args[1];
        if (args[0].equals("Create")) {
            if (!studentsRepo.containsKey(name)) {
                Student student = AddNewStudent.addNewStudent(args);
                studentsRepo.put(name, student);
            }
        } else if (args[0].equals("Show")) {
            if (studentsRepo.containsKey(name)) {
                Student student = studentsRepo.get(name);
                ShowStudentByGrade.showStudent(student);
            }
        }
    }
}
