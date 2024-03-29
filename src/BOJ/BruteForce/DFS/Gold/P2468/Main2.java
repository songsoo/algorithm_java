package BOJ.BruteForce.DFS.Gold.P2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int n,max=0,countMax=0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] count, moveX={-1,0,1,0}, moveY={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S1\\P2468\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j],max);
            }
        }
        count = new int[max];
        for (int i = 1; i < max; i++) {
            visited = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && arr[j][k]>i){
                        visited[j][k] = true;
                        count[i]++;
                        dfs(j,k,i);
                    }else if(arr[j][k]<=i){
                        visited[j][k] = true;
                    }
                }
            }
            countMax = Math.max(countMax,count[i]);

        }
        System.out.println(countMax);


    }
    public static void dfs(int x, int y, int idx){
        for (int i = 0; i < 4; i++) {
            int newX = x+moveX[i];
            int newY = y + moveY[i];

            if (newX < n && newX >= 0 && newY < n && newY >= 0 && !visited[newX][newY] && arr[newX][newY] > idx) {
                visited[newX][newY] = true;
                dfs(newX,newY,idx);
            }
        }
    }

}
