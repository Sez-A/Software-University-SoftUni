package retake_exam_14_april_2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> tulips = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> daffodils = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bouquetsCnt = 0;
        int storeSums = 0;
        while (!daffodils.isEmpty()) {

            if (tulips.isEmpty()) {
                break;
            }

            int tulipsInd = tulips.size() - 1;
            int daffodilsInd = 0;

            int sum = 0;
            Integer tulip = tulips.get(tulipsInd);
            Integer daffodil = daffodils.get(daffodilsInd);

            sum = tulip + daffodil;

            while (sum > 15) {
                tulip -= 2;
                sum = tulip + daffodil;
            }
            if (sum == 15) {
                bouquetsCnt++;
                tulips.remove(tulipsInd);
                daffodils.remove(daffodilsInd);
            } else {
                tulips.remove(tulipsInd);
                daffodils.remove(daffodilsInd);
                storeSums += sum;
            }
        }

        int additionalBouquets = (int) Math.floor((1.0 * storeSums) / 15);

        bouquetsCnt += additionalBouquets;
        if (bouquetsCnt >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquetsCnt);
        } else {
            int diff = 5 - bouquetsCnt;
            System.out.printf("You failed... You need more %d bouquets.%n", diff);
        }
    }
}
