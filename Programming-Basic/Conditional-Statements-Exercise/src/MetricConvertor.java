import java.util.Scanner;

public class MetricConvertor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());

        String metricTypeAsInput = scan.nextLine();
        String metricTypeOutput = scan.nextLine();

        if (metricTypeAsInput.equals("m") && metricTypeOutput.equals("mm")) {
            num *= 1000;
        } else if (metricTypeAsInput.equals("m") && metricTypeOutput.equals("cm")) {
            num *= 100;
        } else if (metricTypeAsInput.equals("cm") && metricTypeOutput.equals("mm")) {
            num *= 10;
        } else if (metricTypeAsInput.equals("cm") && metricTypeOutput.equals("m")) {
            num /= 100;
        } else if (metricTypeAsInput.equals("mm") && metricTypeOutput.equals("cm")) {
            num /= 10;
        } else if (metricTypeAsInput.equals("mm") && metricTypeOutput.equals("m")) {
            num /= 1000;
        }
        System.out.println(String.format("%.3f",num));
    }
}
