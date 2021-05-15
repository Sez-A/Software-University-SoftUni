import java.util.Scanner;

public class SpeedInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double speed = Double.parseDouble(scan.nextLine());
        String condition = "";
        if(speed <= 10 ) {
            condition += "slow";
        }else if(speed > 10 && speed <= 50) {
            condition = "average";
        }else if(speed > 50 && speed <= 150) {
            condition += "fast";
        }else if(speed > 150 && speed <= 1000){
            condition += "ultra fast";
        }else {
            condition += "extremely fast";
        }

       System.out.println(condition);

    }
}
