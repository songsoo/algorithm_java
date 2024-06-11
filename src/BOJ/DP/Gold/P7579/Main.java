package BOJ.DP.Gold.P7579;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] activated, cost;
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        activated = new int[N+1];
        cost = new int[N+1];
        int tmp = 0;
        int tmpIdx = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            activated[i] = Integer.parseInt(st.nextToken());
            tmp += activated[i];
            if(tmp>=M){
                tmpIdx = i;
            }
        }
        tmp = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            if(i <= tmpIdx){
                tmp += cost[i];
            }
        }

        dp = new long[N+1][tmp+1];

        for (int i = 1; i <= N; i++) {
            int curAct = activated[i];
            int curCost = cost[i];

            for (int j = 0; j <= tmp; j++) {
                if(j-curCost>=0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-curCost]+curAct);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= tmp; i++) {
            if(dp[N][i]>=M){
                result = i;
                break;
            }
        }

        System.out.println(result);



    }
}
