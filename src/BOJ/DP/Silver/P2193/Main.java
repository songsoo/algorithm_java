package BOJ.DP.Silver.P2193;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long dp[];
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N+1];
        System.out.println(countPinary(N-2));
    }

    public static long countPinary(int idx){
        if(idx<=0){
            return 1;
        }else if(dp[idx]!=0){
            return dp[idx];
        }
        long res = 0;
        res += countPinary(idx-2 < 0 ? 0 : idx-2);
        res += countPinary(idx-1 < 0 ? 0 : idx-1);
        dp[idx] = res;
        return dp[idx];
    }
}
