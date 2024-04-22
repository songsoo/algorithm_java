package BOJ.BruteForce.BFS.Gold.P14466;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int N,R,K;
    static boolean[][] map;
    static ArrayList<int[]> cows;
    static boolean[][] visited;
    static int[] moveX = {-1 ,0 ,1 ,0}, moveY = {0, -1, 0, 1};
    static boolean[][][][] route;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        route = new boolean[N+1][N+1][N+1][N+1];
        map = new boolean[N+1][N+1];
        cows = new ArrayList<>();
        visited = new boolean[N+1][N+1];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            route[x1][y1][x2][y2] = true;
            route[x2][y2][x1][y1] = true;
        }

        for (int i = 1; i < K+1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
            cows.add(new int[]{x, y});
        }
        int res = K * (K-1) / 2;
        for (int[] cur : cows) {
            int pair = 0;
            if(!visited[cur[0]][cur[1]]){
                visited[cur[0]][cur[1]] = true;
                pair = bfs(cur[0], cur[1]);
            }
            res -= pair * (pair-1) / 2;
        }
        System.out.println(res);

    }
    public static boolean check(int x, int y){
        return x>0 && x<=N && y>0 && y<=N && !visited[x][y];
    }

    public static int dfs(int x, int y){
        int res = 0;
        if(map[x][y]){
            res++;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x+moveX[i];
            int nextY = y+moveY[i];
            if(check(nextX, nextY) && !route[x][y][nextX][nextY]){
                visited[nextX][nextY] = true;
                res += dfs(nextX, nextY);
            }
        }
        return res;
    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int res = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(map[cur[0]][cur[1]]){
                res++;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = x+moveX[i];
                int nextY = y+moveY[i];
                if(check(nextX, nextY) && !route[x][y][nextX][nextY]){
                    visited[nextX][nextY] = true;
                    res += dfs(nextX, nextY);
                }
            }
        }
        return res;
    }
}