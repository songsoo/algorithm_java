package BOJ.DP.G3.P1600;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1600 {
    static int n, m, k;
    static int[][] map;
    static int[][][] visited;
    static int[] moveX={-1,0,1,0}, moveY={0,-1,0,1};
    static int[] moveHX= {1,2,2,1,-1,-2,-2,-1}, moveHY={-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SooHyeon\\intelliJWorkSpace\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m][k+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(visited[i][j],Integer.MAX_VALUE);
            }
        }
        bfs(k);
    }

    public static void bfs(int k){
        Queue<move> queue = new LinkedList<>();
        queue.add(new move(0,0,k,0));
        visited[0][0][k] = 0;
        boolean find = false;
        while(!queue.isEmpty()){

            move cur = queue.poll();
            if(cur.x == n-1 && cur.y==m-1){
                System.out.println(cur.count);
                find = true;
                break;
            }
            if(cur.k>0){
                for (int i = 0; i < 8; i++) {
                    int nextX = cur.x + moveHX[i];
                    int nextY = cur.y + moveHY[i];
                    if(check(nextX,nextY,cur.k-1, cur.count)){
                        visited[nextX][nextY][cur.k-1] = cur.count;
                        queue.add(new move(nextX,nextY,cur.k-1,cur.count+1));
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];
                if(check(nextX,nextY,cur.k, cur.count)){
                    visited[nextX][nextY][cur.k] = cur.count;
                    queue.add(new move(nextX,nextY,cur.k,cur.count+1));
                }
            }
        }
        if(!find){
            System.out.println("-1");
        }

    }

    public static boolean check(int x, int y, int k, int count){
        if(x>=0 && x<n && y>=0 && y<m  && map[x][y]!= 1 && checkVisit(x,y,count,k)){
            return true;
        }
        return false;
    }

    public static boolean checkVisit(int x, int y, int count, int curK){
        for (int i = k; i >= curK ; i--) {
            if(visited[x][y][i] <= count){
                return false;
            }
        }
        return true;
    }
}
class move{
    int x;
    int y;
    int k;
    int count;

    move(int x, int y, int k, int count){
        this.x = x;
        this.y = y;
        this.k = k;
        this.count = count;
    }

}
