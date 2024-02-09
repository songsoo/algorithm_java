package BOJ.BruteForce.BackTracking.Gold.P1405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double probabilities[];
    static double result;
    static boolean[][] visited;
    static int[] moveX={0,0,1,-1},moveY={1,-1,0,0};
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        probabilities = new double[4];
        for (int i = 0; i < 4; i++) {
            probabilities[i] = Integer.parseInt(st.nextToken())/100.0;
        }
        visited = new boolean[N*2+1][N*2+1];
        result = 0;
        visited[N][N]=true;
        goNext(0,1, N, N);
        System.out.println(result);
    }

    public static void goNext(int cnt, double prob, int x, int y){
        if (cnt==N){
            result+=prob;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            if(check(nextX,nextY)){
                visited[nextX][nextY]=true;
                goNext(cnt+1,prob*probabilities[i],nextX,nextY);
                visited[nextX][nextY]=false;
            }
        }
    }

    public static boolean check(int x, int y){
        if(x>=2*N+1 || x<0 || y>=2*N+1 || y<0||visited[x][y]==true ){
            return false;
        }
        return true;
    }
}
