import java.util.Scanner;

public class Snowball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double valueNow = -1;
        int snowballSnowNow = 0;
        int snowballTimeNow = 0;
        int snowballQualityNow = 0;
        for (int i = 0; i < n ; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());
            //(snowballSnow / snowballTime) ^ snowballQuality
            double snowballValue = Math.pow((snowballSnow / snowballTime),snowballQuality) ;
            if(snowballValue > valueNow){
                valueNow = snowballValue;
                snowballSnowNow = snowballSnow;
                snowballTimeNow = snowballTime;
                snowballQualityNow = snowballQuality;
            }
        }
        //{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})
        System.out.println(String.format("%d : %d = %.0f (%d)",snowballSnowNow,snowballTimeNow,valueNow,snowballQualityNow));
    }
}
