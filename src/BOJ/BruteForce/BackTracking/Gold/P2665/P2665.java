package BOJ.BruteForce.BackTracking.Gold.P2665;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2665 {
    static int N, min;
    static char[][] arr;
    static int[][] visited;
    static int[] moveX = {-1,0,1,0}, moveY={0,-1,0,1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        min = Integer.MAX_VALUE;
        arr = new char[N][N];
        visited= new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        dfs(0,0,0);
        System.out.println(min);
    }

    public static void dfs(int x, int y, int count){
        if(x==N-1 && y==N-1){
            min = Math.min(min,count);
            return;
        }
        visited[x][y] = count;
        for (int i = 0; i < 4; i++) {
            int nextX = x+moveX[i];
            int nextY = y+moveY[i];
            if(check(nextX,nextY)){
                int nextCount = count + (((arr[nextX][nextY]-'0')+1)%2);
                if(visited[nextX][nextY]>nextCount){
                    dfs(nextX,nextY,nextCount);
                }
            }
        }
    }
    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }return false;
    }
}
