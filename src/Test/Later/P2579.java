package Test.Later;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int[][] dp = new int[n+1][3];

        Arrays.fill(dp[0],0);
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];
        dp[1][2] = 0;

        for (int i = 2; i < n+1; i++) {
            // 2칸 건너온 것
            dp[i][0] = Math.max(Math.max(dp[i-2][0],dp[i-2][1]),dp[i-2][2]) + arr[i];
            // 1칸 첫번째 건넌 것
            dp[i][1] = dp[i-1][0] + arr[i];
            // 1칸 두번째 건넌 것
            dp[i][2] = dp[i-1][1] + arr[i];
            System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]);

        }


    }
}
