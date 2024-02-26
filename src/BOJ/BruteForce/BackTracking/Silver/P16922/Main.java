package BOJ.BruteForce.BackTracking.Silver.P16922;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int N, result;
    static HashSet<Integer>[] set;
    static int[] words = {1, 5, 10, 50};
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        set = new HashSet[N+1];
        for (int i = 0; i < N+1; i++) {
            set[i] = new HashSet<>();
        }
        result = 0;
        goNext(0, 0);
        System.out.println(result);
    }

    public static void goNext(int index, int sum){

        if(index == N){
            result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(!set[index+1].contains(sum+words[i])){
                set[index+1].add(sum+words[i]);
                goNext(index+1, sum + words[i]);
            }
        }
    }

}
