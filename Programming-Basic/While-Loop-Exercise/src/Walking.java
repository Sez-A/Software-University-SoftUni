import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int steps = 0;
        while (steps < 10000) {
            String line = scan.nextLine();

            if (line.equals("Going home")) {
                int currentSteps = Integer.parseInt(scan.nextLine());
                steps += currentSteps;
                break;
            }
            int currentSteps = Integer.parseInt(line);
            steps += currentSteps;

        }

        if (steps > 10000) {
            System.out.printf("Goal reached! Good job!%n" +
                    "%d steps over the goal!%n", steps - 10000);
        } else {
            System.out.printf("%d more steps to reach goal.%n", 10000 - steps);
        }
    }
}
