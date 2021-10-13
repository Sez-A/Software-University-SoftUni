import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        while (n-- > 0) {
            String line = scan.nextLine();
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(name, new ArrayList<>());
            List<Double> grades = students.get(name);
            grades.add(grade);
            students.put(name, grades);
        }


        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            List<Double> value = entry.getValue();
            int cnt = 0;
            double sum = 0;
            for (Double cv : value) {
                sum += cv;
                cnt++;
            }
            sum /= cnt;
            System.out.println(String.format("%s -> %s (avg: %.2f)", entry.getKey()
                    , getGrades(entry.getValue()), sum));
        }
    }


    private static String getGrades(List<Double> grades) {
        return grades.stream()
                .map(g -> String.format("%.2f",g))
                .collect(Collectors.joining(" "));
    }
}
