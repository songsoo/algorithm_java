package BOJ.BruteForce.BFS.S1.P2667;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, count;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX={-1,0,1,0}, moveY={0,-1,0,1};
    static int[] countHouse;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S1\\P2667\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        count = 0;
        countHouse = new int[n*n];

        for (int i = 0; i < n; i++) {
            char[] temp = bf.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[j]-'0';
                if(arr[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    visited[i][j]=true;
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);
        countHouse = Arrays.copyOf(countHouse,count);
        Arrays.sort(countHouse);
        for (int i = 0; i < count; i++) {
            System.out.println(countHouse[i]);
        }



    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        count++;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            arr[cur[0]][cur[1]] = count;
            countHouse[count-1]++;
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + moveX[i];
                int newY = cur[1] + moveY[i];
                if(newX<n && newX>=0 && newY<n && newY>=0 &&!visited[newX][newY] ){
                    visited[newX][newY] = true;
                    queue.add(new int[] {newX, newY});
                }
            }
        }

    }
}
