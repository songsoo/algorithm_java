package BOJ.NumberTheory.Combination.P2407;

import java.math.BigInteger;
import java.util.Scanner;

//2407
public class Main {
    static BigInteger dp[][];
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        dp = new BigInteger[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = new BigInteger("0");
            }
        }
        int n = sc.nextInt();
        int k = sc.nextInt();
        k = Math.min(k, n-k);
        System.out.println(comb(n,k));
    }

    public static BigInteger comb(int n, int k){
        // k가 1이 되면 n 리턴
        k = Math.min(k, n-k);
        if(k==1){
            return new BigInteger(Integer.toString(n));
        }else if(k==0){
            return new BigInteger("1");
        }else{
            if(dp[n-1][k].equals(new BigInteger("0"))){
                dp[n-1][k] = comb(n-1,k);
            }
            if(dp[n-1][k-1].equals(new BigInteger("0"))){
                dp[n-1][k-1] = comb(n-1,k-1);
            }
            return dp[n-1][k].add(dp[n-1][k-1]);
        }

    }
}
