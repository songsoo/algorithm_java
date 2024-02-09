package BOJ.DP.Gold.P10942;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i],-1);
        }

        M = Integer.parseInt(bf.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(goCheck(S,E)+"\n");

        }
        System.out.println(sb.toString());

    }

    public static int goCheck(int S, int E){
        //지정된 값이 있으면 그걸 return
        if(dp[S][E]!=-1){
            return dp[S][E];
        }
        //종료 지점 check
        if(S==E){
            dp[S][E] = 1;
            return dp[S][E];
        }
        if(S==E-1){
            dp[S][E] = arr[S]==arr[E] ? 1:0;
            return dp[S][E];
        }
        //지정된 값이 없으면
        else{
            dp[S][E] = (arr[S]==arr[E]?1:0) * goCheck(S+1,E-1);
            return dp[S][E];
        }

    }
}
