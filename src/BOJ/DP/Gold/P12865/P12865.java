package BOJ.DP.Gold.P12865;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {
   static int N, K;
    static Node[] nodes;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\SooHyeon\\intelliJWorkSpace\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nodes = new Node[N+1];
        dp = new int[N+1][K+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(w,v);
        }

        for (int i = 1; i < N+1; i++) {
            int w = nodes[i].weight;
            int v = nodes[i].value;
            for (int j = 1; j <= K; j++) {
                if(j-w>=0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
    private static class Node{
        int value;
        int weight;

        Node(int weight, int value){
            this.value = value;
            this.weight = weight;
        }
    }


}
