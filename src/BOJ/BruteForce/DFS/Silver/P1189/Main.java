package BOJ.BruteForce.DFS.Silver.P1189;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, result;
    static int[] moveX = {-1, 0, 1, 0}, moveY = {0, -1 ,0 ,1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        dfs(R-1, 0, 1);
        System.out.println(result);
    }
    public static void dfs(int x, int y, int cnt){
        if(x == 0 && y == C-1){
            if(cnt==K){
                result++;
            }
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            if(check(nextX, nextY) && !visited[nextX][nextY]){
                dfs(nextX, nextY, cnt+1);
            }
        }
        visited[x][y] = false;

    }
    public static boolean check(int x, int y){
        return x>=0 && x<R && y>=0 && y<C && map[x][y]!='T';
    }
}