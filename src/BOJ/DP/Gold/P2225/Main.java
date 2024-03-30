package BOJ.DP.Gold.P2225;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long result;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        for (int i = 0; i < N+1; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = 0; i < K+1; i++) {
            dp[0][i] = 1;
        }
        System.out.println(goNext(N,K));
    }
    public static int goNext(int n, int k){
        if(n== 0 || k==1){
            return 1;
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if(dp[i][k-1]==0){
                dp[i][k-1] = goNext(i, k-1);
            }
            sum += dp[i][k-1];
            sum %= 1000000000;
        }
        return sum;

    }

}
