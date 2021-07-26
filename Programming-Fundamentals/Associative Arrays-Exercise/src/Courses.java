import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input;
        while (!(input = scan.nextLine()).equals("end")) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String student = tokens[1];
            courses.putIfAbsent(courseName, new ArrayList<>());
            List<String> students = courses.get(courseName);
            students.add(student);
            courses.put(courseName, students);
        }

        courses
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    int firstCourse = c1.getValue().size();
                    int secondCourse = c2.getValue().size();
                    return Integer.compare(secondCourse, firstCourse);
                }).forEach(c -> {
            System.out.printf("%s: %d%n", c.getKey(), c.getValue().size());
            List<String> students = c.getValue();
            students.stream()
                    .sorted((s1, s2) -> s1.compareTo(s2))
                    .forEach(s -> System.out.println("-- " + s));
        });
    }
}
