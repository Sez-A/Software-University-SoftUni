package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            if(tokens.length == 3) {
                rebels.add(new Rebel(tokens[0],Integer.parseInt(tokens[1]),tokens[2]));
            }else {
                citizens.add(new Citizen(tokens[0],
                        Integer.parseInt(tokens[1]),tokens[2],tokens[3]));
            }
        }
        String name = reader.readLine();
        while (!name.equals("End")) {
            citizenIsContained(name,citizens);
            rebelIsContained(name,rebels);
            name = reader.readLine();
        }

        System.out.println(totalFoodAmount(citizens, rebels));
    }

    private static int totalFoodAmount(List<Citizen> citizens, List<Rebel> rebels) {
        int amount = 0;
        for (Citizen citizen : citizens) {
            amount += citizen.getFood();
        }
        for (Rebel rebel : rebels) {
            amount += rebel.getFood();
        }
        return  amount;
    }

    private static void citizenIsContained(String name, List<Citizen> citizens) {
        for (Citizen citizen : citizens) {
            if(citizen.getName().equals(name)) {
                citizen.buyFood();
                break;
            }
        }
    }

    private static void rebelIsContained(String name, List<Rebel> rebels) {
        for (Rebel rebel : rebels) {
            if(rebel.getName().equals(name)) {
                rebel.buyFood();
                break;
            }
        }
    }
}
