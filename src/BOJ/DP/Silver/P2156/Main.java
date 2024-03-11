package BOJ.DP.Silver.P2156;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[10000];
        dp = new int[10000];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        dp[0] = arr[0];
        dp[1] = dp[0]+arr[1];
        dp[2] = Math.max(Math.max(arr[0]+arr[2], arr[0]+arr[1]), arr[1]+arr[2]);
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i]+arr[i-1]));
        }

        System.out.println(dp[N-1]);

    }

}
