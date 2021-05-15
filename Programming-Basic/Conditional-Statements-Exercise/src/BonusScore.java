import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        double bonusScore = 0;
        if(num <= 100) {
            bonusScore += 5;
        }else if (num >= 1000) {
            bonusScore += (num * 0.1);
        }else {
            bonusScore += (num * 0.2);
        }

        if(num % 10 == 5) {
            bonusScore += 2;
        }
        if(num % 2 == 0) {
            bonusScore += 1;
        }

        double totalScore = num + bonusScore;

        System.out.printf("%.1f%n",bonusScore);
        System.out.printf("%.1f%n",totalScore);
    }
}
