package BOJ.DP.Gold.P6087;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {
    static int N,M,min;
    static char map[][];
    static int dp[][][];
    static int turn[][] = {{3, 1},{2, 0},{1,3},{0,2}};
    static boolean visited[][];
    static ArrayList<Point> laser;
    static int[] moveX={0,1,0,-1}, moveY={1,0,-1,0}, start, end;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new int[N][M][4];
        start = new int[2];
        end = new int[2];
        laser = new ArrayList<>();

        min = 100000;
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                char cur = str.charAt(j);
                map[i][j] = cur;
                if (cur == 'C') {
                    laser.add(new Point(i, j, 0,0));
                }
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        start[0] = laser.get(0).x;
        start[1] = laser.get(0).y;
        end[0] = laser.get(1).x;
        end[1] = laser.get(1).y;


        for (int i = 0; i < 4; i++) {
            visited = new boolean[N][M];
            goNext(start[0], start[1], 0, i);
        }

        System.out.println(min);
    }
    public static void goNext(int x, int y, int mirrorNum, int dir){
        //도착 시 거울 수 리턴
        if(x==end[0] && y==end[1]){
            min = Math.min(min, mirrorNum);
            return;
        }

        int nextX = x + moveX[dir];
        int nextY = y + moveY[dir];
        // 직선 방향
        if(check(nextX, nextY) && dp[nextX][nextY][dir] > mirrorNum && min > mirrorNum && !visited[nextX][nextY]){
            dp[nextX][nextY][dir] = mirrorNum;
            visited[nextX][nextY] = true;
            goNext(nextX, nextY, mirrorNum, dir);
            visited[nextX][nextY] = false;
        }
        mirrorNum++;
        // '/'
        int nextDir = turn[dir][0];
        nextX = x + moveX[nextDir];
        nextY = y + moveY[nextDir];
        if(check(nextX, nextY) && dp[nextX][nextY][nextDir] > mirrorNum && min > mirrorNum && !visited[nextX][nextY]){
            dp[nextX][nextY][nextDir] = mirrorNum;
            visited[nextX][nextY] = true;
            goNext(nextX, nextY, mirrorNum, nextDir);
            visited[nextX][nextY] = false;
        }
        // '\'
        nextDir = turn[dir][1];
        nextX = x + moveX[nextDir];
        nextY = y + moveY[nextDir];
        if(check(nextX, nextY) && dp[nextX][nextY][nextDir] > mirrorNum && min > mirrorNum && !visited[nextX][nextY]){
            dp[nextX][nextY][nextDir] = mirrorNum;
            visited[nextX][nextY] = true;
            goNext(nextX, nextY, mirrorNum, nextDir);
            visited[nextX][nextY] = false;
        }
    }

    public static boolean check(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M && map[x][y]!='*');
    }

}
class Point implements Comparable<Point>{
    int x;
    int y;
    int direction;
    int mirrorCount;

    public Point(int x, int y, int direction, int mirrorCount) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.mirrorCount = mirrorCount;
    }

    @Override
    public int compareTo(Point o) {
        return this.mirrorCount-o.mirrorCount;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                ", mirrorCount=" + mirrorCount +
                '}';
    }
}