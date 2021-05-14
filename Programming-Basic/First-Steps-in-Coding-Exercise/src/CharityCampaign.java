import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int campaignDays = Integer.parseInt(scan.nextLine());
        int confectionersCnt = Integer.parseInt(scan.nextLine());
        int cakesCnt = Integer.parseInt(scan.nextLine());
        int wafflesCnt = Integer.parseInt(scan.nextLine());
        int pancakesCnt = Integer.parseInt(scan.nextLine());

        double cakesProfit = cakesCnt * 45;
        double wafflesProfit = wafflesCnt * 5.80;
        double pancakesProfit = pancakesCnt * 3.20;

        double profitPerDay = (cakesProfit + wafflesProfit + pancakesProfit)
                * confectionersCnt;

        double totalMoneyPerPeriod = profitPerDay * campaignDays;

        double moneyForCharity = totalMoneyPerPeriod - (totalMoneyPerPeriod / 8);

        System.out.printf("%.2f",moneyForCharity);

    }
}
