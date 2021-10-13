import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();
        while (n-- > 0) {
            String studentName = scan.nextLine();
            Double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .boxed()
                    .toArray(Double[]::new);

            if (!students.containsKey(studentName)) {
                students.put(studentName, new ArrayList<>());
                List<Double> currentGrades = students.get(studentName);
                for (Double grade : grades) {
                    currentGrades.add(grade);
                }
            } else {
                List<Double> currentGrades = students.get(studentName);
                for (Double grade : grades) {
                    currentGrades.add(grade);
                }
            }
        }

        students
                .entrySet()
                .forEach(s -> {
                    System.out.printf("%s is graduated with %s%n", s.getKey(), averageGrade(s.getValue()));
                });
    }

    private static String averageGrade(List<Double> grades) {
        Double averageGrade = 0.0;
        for (Double grade : grades) {
            averageGrade += grade;
        }
        averageGrade /= grades.size();
        DecimalFormat format = new DecimalFormat("0.##################################################");
        return format.format(averageGrade);
    }
}
