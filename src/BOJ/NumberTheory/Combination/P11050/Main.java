package BOJ.NumberTheory.Combination.P11050;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] dp;
    static int mod = 1000000007;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        dp = new int[N+1][N+1];

        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        System.out.println(comb(N, M));
    }

    public static int comb(int n, int m){
        if(dp[n][m]!=-1){
            return dp[n][m]%mod;
        }
        if(m == 1 || m == n-1){
            dp[n][m] = n%mod;
            return n%mod;
        }
        return comb(n-1, m-1)%mod + comb(n-1,m)%mod;
    }
}
