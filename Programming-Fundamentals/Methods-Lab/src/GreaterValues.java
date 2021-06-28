import java.util.Scanner;

public class GreaterValue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("int")) {
            int a = Integer.parseInt(scan.nextLine());
            int b = Integer.parseInt(scan.nextLine());
            System.out.println(getMaxInt(a, b));
            getMaxInt(a, b);
        } else if (input.equals("char")) {
            char a = scan.nextLine().charAt(0);
            char b = scan.nextLine().charAt(0);
            System.out.println(getMaxChar(a,b));
            getMaxChar(a, b);
        } else if (input.equals("string")) {
            String a = scan.nextLine();
            String b = scan.nextLine();
            getMaxString(a,b);
            System.out.println(getMaxString(a,b));
        }

    }

    public static int getMaxInt(int a, int b) {
        if(a > b){
            return a;
        }else{
            return b;
        }
    }

    public static char getMaxChar (char a , char b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
    public static String getMaxString (String first, String second){
        if(first.compareTo(second) >= 0){
            return first;
        }
        return second;
    }
}
