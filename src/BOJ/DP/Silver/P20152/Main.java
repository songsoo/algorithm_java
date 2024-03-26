package BOJ.DP.Silver.P20152;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] moveX = {0,1}, moveY={1,0};
    static long dp[][];
    static int N, H, result;
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        N = sc.nextInt();
        result = 0;

        // 무조건 집이 왼쪽 위
        if(H>N){
            int tmp = H;
            H = N;
            N = tmp;
        }
        dp = new long[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(goNext(H,H));

    }

    public static long goNext(int x, int y){
        if(x==N && y==N){
            return 1;
        }

        long sum = 0;

        for (int i = 0; i < 2; i++) {
            int nextX = x+moveX[i];
            int nextY = y+moveY[i];
            if(check(nextX, nextY)){
                if(dp[nextX][nextY]==-1){
                    sum += goNext(nextX, nextY);
                }else{
                    sum += dp[nextX][nextY];
                }
            }
        }
        dp[x][y] = sum;
        return sum;
    }

    public static boolean check(int x, int y){
        return x<=N && y<=N && x>=y;
    }
}
