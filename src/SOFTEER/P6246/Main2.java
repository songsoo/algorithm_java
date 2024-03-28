package SOFTEER.P6246;

import java.io.*;
import java.util.*;

public class Main2 {
    static int[][] map;
    static ArrayList<int[]> points;
    static boolean[][] toVisit, visited;
    static int[] moveX = {-1, 0, 1, 0}, moveY = {0, -1 ,0, 1};
    static int N, M, result;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        toVisit = new boolean[N+1][N+1];
        visited = new boolean[N+1][N+1];
        map = new int[N+1][N+1];
        points = new ArrayList();
        result = 0;
        for(int i=1; i<=N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            toVisit[x][y] = true;
            points.add(new int[]{x, y});
        }

        visited[points.get(0)[0]][points.get(0)[1]] = true;
        goNext(points.get(0)[0], points.get(0)[1], 0);
        System.out.println(result);

    }
    public static void goNext(int x, int y, int cnt){
        if(toVisit[x][y]){
            cnt++;
        }
        if(cnt == M){
            result++;
            return;
        }
        for(int i=0 ; i<4 ; i++){
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            // 갈 수 있는 곳인지 확인 후, 종료지점일 경우 cnt 체크
            if(check(nextX, nextY) && (toVisit[nextX][nextY]) ? (points.get(cnt+1)[0]==nextX && points.get(cnt+1)[1]==nextY) : true){
                visited[nextX][nextY] = true;
                goNext(nextX, nextY, cnt);
                visited[nextX][nextY] = false;
            }
        }
    }
    public static boolean check(int x, int y){
        return x>=1 && x<=N && y>=1 && y<=N && map[x][y]!=1 && !visited[x][y];
    }
}
