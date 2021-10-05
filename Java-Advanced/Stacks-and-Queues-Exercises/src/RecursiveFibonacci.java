import java.util.Scanner;
public class RecursiveFibonacci {

    private  static long[] memoization;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        memoization = new long[n + 1];

        System.out.println(fib(n));
    }

    private static long fib(int n) {
        if (n <= 2) {
            return n;
        }
        if(memoization[n] != 0) {
            return memoization[n];
        }
        return memoization[n]= fib(n -1) + fib(n-2) ;
    }
}
