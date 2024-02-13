package BOJ.BruteForce.Comb_Perm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N,M,count=0;
    static boolean imPoss[][];
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        imPoss = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            imPoss[a][b] = true;
            imPoss[b][a] = true;
        }
        int sum = 0;
        for (int i = 1; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N+1; k++) {
                    if(!imPoss[i][j] && !imPoss[j][k] && !imPoss[i][k]){
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
