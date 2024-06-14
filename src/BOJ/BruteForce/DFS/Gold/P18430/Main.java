package BOJ.BruteForce.DFS.Gold.P18430;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 모양은 ㄴ 모양으로 시작해서 시계 방향으로 회전
    static int N, M, max;
    static int[][] map;
    static int[][][] area;
    static int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1};
    static int[][] shapeX = {{-1,0},{0, 1},{1,0},{0,-1}}, shapeY = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        area = new int[N][M][4];
        visited = new boolean[N][M];
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = map[i][j] * 2;
                for (int k = 0; k < 4; k++) {
                    int sum = cur;
                    int nextX1 = i+shapeX[k][0];
                    int nextX2 = i+shapeX[k][1];
                    int nextY1 = j+shapeY[k][0];
                    int nextY2 = j+shapeY[k][1];
                    if(check(nextX1, nextY1) && check(nextX2, nextY2)){
                        sum += (map[nextX1][nextY1] + map[nextX2][nextY2]);
                    }else{
                        sum = -1;
                    }
                    area[i][j][k] = sum;
                }
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);


    }
    public static void dfs(int x, int y, int sum){
        if(y>=M){
            x++;
            y=0;
        }
        // 위치 맞춰주기, x가 N보다 작으면서 방문한 곳일 경우엔 다음칸으로 넘어감
        while(x<N && visited[x][y]){
            if(++y>=M){
                x++;
                y=0;
            }
        }
        if(x>=N){
            max = Math.max(max, sum);
            return;
        }
        // 선택하지 않음
        dfs(x, y+1, sum);
        // 네가지 방향 선택 후 이동
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX1 = x+shapeX[i][0];
            int nextX2 = x+shapeX[i][1];
            int nextY1 = y+shapeY[i][0];
            int nextY2 = y+shapeY[i][1];
            if(area[x][y][i]!=-1 && !visited[nextX1][nextY1] && !visited[nextX2][nextY2]){
                // visit 체크
                visited[nextX1][nextY1] = true;
                visited[nextX2][nextY2] = true;
                // 방문
                dfs(x, y+1, sum+area[x][y][i]);
                // visit 체크 해제
                visited[nextX1][nextY1] = false;
                visited[nextX2][nextY2] = false;
            }
        }
        visited[x][y] = false;
    }

    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}
