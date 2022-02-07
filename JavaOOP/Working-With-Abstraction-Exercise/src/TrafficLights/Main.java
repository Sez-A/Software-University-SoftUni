package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TrafficLights[] trafficLights = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(e -> TrafficLights.valueOf(e))
                .toArray(TrafficLights[]::new);

        int n = Integer.parseInt(scan.nextLine());

        TrafficLights[] sequenceOfLights = TrafficLights.values();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                TrafficLights current = trafficLights[j];
                int nextLightIndex = current.ordinal() + 1;
                TrafficLights next = sequenceOfLights[nextLightIndex % sequenceOfLights.length];
                System.out.print(next + " ");
                trafficLights[j] = next;
            }
            System.out.println();
        }
    }
}
