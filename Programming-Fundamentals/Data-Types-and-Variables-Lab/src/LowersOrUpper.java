import java.util.Scanner;

public class LowersOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String character = scan.nextLine();
        if(character.equals(character.toLowerCase())){
            System.out.println("lower-case");
        }else{
            System.out.println("upper-case");
        }
    }
}
