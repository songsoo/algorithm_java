package BOJ.DP.Gold.P1915;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static char[][] map;
    static int[][] dp;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;

        map = new char[N+1][M+1];
        dp = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            map[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='1' && dp[i][j]==-1){
                    dp[i][j] = dfs(i, j);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println((int)Math.pow(max,2));

    }
    public static int dfs(int x, int y){
        if(!check(x,y) ||map[x][y]=='0'){
            return 0;
        }

        int right = 0;
        if(check(x,y+1)){
            if(dp[x][y+1]==-1){
                right = dfs(x, y+1);
                dp[x][y+1] = right;
                max = Math.max(max, right);
            }else{
                right = dp[x][y+1];
            }
        }

        int down = 0;
        if(check(x+1,y)){
            if(dp[x+1][y]==-1){
                down = dfs(x+1, y);
                dp[x+1][y] = down;
                max = Math.max(max, down);
            }else{
                down = dp[x+1][y];
            }
        }

        if(down==right && map[x+down][y+right]=='0'){
            down--;
            right--;
        }

        return Math.min(down, right) + 1;
    }

    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}
