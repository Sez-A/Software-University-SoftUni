import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine()); // мощност
        int M = Integer.parseInt(scan.nextLine()); // разстояние
        int Y = Integer.parseInt(scan.nextLine()); // изчерпване
        double originalValue = N * 0.5;
        int pokeTargetCnt = 0;
        while (N >= M){
            if(N == originalValue){
                if(Y > 0){
                    N = N / Y;
                }
                if(N < M ){
                    break;
                }
            }
            N -= M;
           pokeTargetCnt ++;
        }
        System.out.println(N);
        System.out.println(pokeTargetCnt);
    }
}
