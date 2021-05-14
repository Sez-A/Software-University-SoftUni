import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dogCnt = Integer.parseInt(scan.nextLine());
        int otherAnimalsCnt = Integer.parseInt(scan.nextLine());

        double dogFoodPrice = dogCnt * 2.50;
        double otherAnimalsFoodPrice = otherAnimalsCnt * 4;

        double totalPrice = dogFoodPrice + otherAnimalsFoodPrice;

        System.out.println(totalPrice + " lv.");
    }
}
